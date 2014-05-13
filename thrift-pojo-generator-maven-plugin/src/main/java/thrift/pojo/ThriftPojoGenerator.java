package thrift.pojo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;
import com.thoughtworks.qdox.model.Type;
import thrift.pojo.classes.PojoClass;
import thrift.pojo.classes.PojoEnum;
import thrift.pojo.classes.PojoInterface;

/**
 * @goal generate-sources
 * @phase generate-sources
 */
public class ThriftPojoGenerator extends AbstractMojo {
    private static final String TEMPLATES_THRIFT_POJO = "templates/thriftPojo.stg";
    private static final String THRIFT_CLASS_BASE = "org.apache.thrift.TBase";
    private static final String THRIFT_CLASS_ENUM = "org.apache.thrift.TEnum";
    private static final String THRIFT_CLASS_EXCEPTION = "org.apache.thrift.TException";
    private static final String POJO_CLASS_EXCEPTION = "java.lang.Exception";
    private static final String POJO_CLASS_MAP = "java.util.Map";
    public static final String POJO_CLASS_LIST = "java.util.List";
    private static final String JAVA_EXTENSION = ".java";
    private static final String POJO_POSTFIX_BRIDGE = "Bridge";

    /**
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 * @since 1.0
	 */
	private MavenProject project;

	/**
     * List of source packages. The content will be parsed recursively
     *
	 * @parameter
	 * @required
	 */
	private List<String> sources;

	/**
     * Output directory for the generated Pojos
     *
	 * @parameter default-value="target/generated-sources"
	 * @required
	 */
	private File outputDirectory;

	/**
     * Generated files need a postfix in order to differenciate from the original ones. Default is "Pojo"
     *
	 * @parameter default-value="Pojo"
	 */
	private String outputPostfix = null;

	/**
     * All the generated classes will extend this interface (i.e. java.io.Serializable)
     *
	 * @parameter
	 */
	private String interfaceName = null;

	/**
     * Package where the generated files will be persisted
     *
	 * @parameter
	 */
	private String destinationPackage = null;

	/**
     * If defined, only classes on those packages will generate pojos
     *
	 * @parameter
	 */
	private List<String> packageBaseList = null;

	@Override
	public void execute() throws MojoExecutionException{
		try {
			STGroup template = new STGroupFile(TEMPLATES_THRIFT_POJO);
			JavaDocBuilder docBuilder = getBuilder();

			getLog().info(
					String.format("Executing ThriftPojoGenerator. Sources [ %s ]; outputDirectory [ %s ]; postfix [ %s ]; inteface [ %s ]", sources,
							outputDirectory, outputPostfix, interfaceName));

			generate(template, docBuilder);

			project.addCompileSourceRoot(outputDirectory.getAbsolutePath());
		} catch (Exception e) {
			getLog().error("General error", e);
            throw new MojoExecutionException("Error generatings Pojos", e);
		}
	}

	private void generate(STGroup template, JavaDocBuilder docBuilder) throws Exception {
		Map<String, PojoInterface> thirftNameToPojoClassMap = new HashMap<String, PojoInterface>();

		for (JavaClass jc : docBuilder.getClasses()) {
			if (!jc.isInterface() && !jc.isInner() && getSource(jc) != null) {
				PojoInterface pojo = null;
				if (jc.isA(THRIFT_CLASS_BASE)) {
					pojo = generateClassBuilderFor(jc, template);
				} else if (jc.isA(THRIFT_CLASS_ENUM)) {
					pojo = generateEnumBuilderFor(jc, template);
				}
				if (pojo != null) {
					thirftNameToPojoClassMap.put(pojo.getRemoteName(), pojo);
				}
			}
		}

		for (Map.Entry<String, PojoInterface> entry : thirftNameToPojoClassMap.entrySet()) {
			getLog().info("Writing pojo: " + entry.getValue().toString());
			writeClass(entry.getValue().getClassPackage().replaceAll("\\.", "/"), entry.getValue().getClassName() + JAVA_EXTENSION,
					entry.getValue().getPojoClass(template, thirftNameToPojoClassMap));
			writeClass(entry.getValue().getClassPackage().replaceAll("\\.", "/"), entry.getValue().getClassName() + POJO_POSTFIX_BRIDGE + JAVA_EXTENSION, entry.getValue()
					.getBridgeClass(template, thirftNameToPojoClassMap));
		}
	}

	private JavaDocBuilder getBuilder() {
		JavaDocBuilder docBuilder = new JavaDocBuilder();
		for (String r : sources) {
			docBuilder.addSourceTree(new File(r));
		}

		return docBuilder;
	}

	private PojoClass generateClassBuilderFor(JavaClass javaClass, STGroup template) throws IOException {
		for (JavaMethod method : javaClass.getMethods()) {
			if (isAllArgumentsConstructor(javaClass, method)) {
				PojoClass pojo = new PojoClass(getGeneratedClassPackage(javaClass), getPojoClassName(javaClass.getName()), javaClass.getFullyQualifiedName(),
						interfaceName, getPojoSuperclass(javaClass));
				for (JavaParameter p : method.getParameters()) {
					if (p.getType().isA(new Type(POJO_CLASS_MAP))) {
						pojo.addMapParameter(p.getType().toGenericString(), p.getName());
					} else if(p.getType().isA(new Type(POJO_CLASS_LIST))){
                        pojo.addListParameter(p.getType().toGenericString(), p.getName());
                    }else {
						pojo.addParameter(p.getType().toGenericString(), p.getName());
					}
				}

				return pojo;
			}
		}

		return null;
	}

	private String getPojoSuperclass(JavaClass javaClass) {
		if (javaClass.getSuperClass().getFullyQualifiedName().equals(THRIFT_CLASS_EXCEPTION)) {
			return POJO_CLASS_EXCEPTION;
		} else {
			return null;
		}
	}

	private PojoEnum generateEnumBuilderFor(JavaClass javaClass, STGroup template) throws IOException {
		PojoEnum enumPojo = new PojoEnum(getGeneratedClassPackage(javaClass), getPojoClassName(javaClass.getName()), javaClass.getFullyQualifiedName());

		for (JavaField field : javaClass.getFields()) {
			if (!field.getName().equals("value")) {
				enumPojo.addType(field.getName());
			}
		}

		return enumPojo;
	}

	private String getGeneratedClassPackage(JavaClass sourceJavaClass) {
		String classPackage = sourceJavaClass.getPackageName();
		if (this.destinationPackage == null) {
			return classPackage;
		} else {
			String sourcePackage = getSource(sourceJavaClass);
			return destinationPackage + (sourcePackage != null ? (classPackage.substring(getSource(sourceJavaClass).length())) : classPackage);
		}
	}

	private String getSource(JavaClass sourceJavaClass) {
		String classSource = null;
		String classPackage = sourceJavaClass.getPackageName();
		if (packageBaseList != null) {
			for (String source : packageBaseList) {
				if (classPackage.startsWith(source) && (classSource == null || source.length() > classSource.length())) {
					classSource = source;
				}
			}
		} else {
			classSource = classPackage;
		}

		return classSource;
	}

	private String getPojoClassName(String thirftClassName) {
		return (outputPostfix != null && !outputPostfix.isEmpty()) ? thirftClassName + outputPostfix : thirftClassName;
	}

	protected void writeClass(String folder, String fileName, String content) throws IOException {
		getLog().debug(String.format("Writing %s in %s", fileName, folder));
		File pd = new File(outputDirectory, folder);
		pd.mkdirs();

		FileWriter out = new FileWriter(new File(pd, fileName));
		try {
			out.append(content);
		} finally {
			out.flush();
			out.close();
		}
	}

	private boolean isAllArgumentsConstructor(JavaClass javaClass, JavaMethod method) {
		return method.isConstructor()
				&& method.getParameters().length > 0
				&& !(method.getParameters().length == 1 && method.getParameters()[0].getType().getFullyQualifiedName()
						.equals(javaClass.getFullyQualifiedName()));
	}

    // Setters for testing purposes
    protected void setProject(MavenProject project) {
        this.project = project;
    }

    protected void setSources(List<String> sources) {
        this.sources = sources;
    }

    protected void setOutputPostfix(String outputPostfix) {
        this.outputPostfix = outputPostfix;
    }

    protected void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    protected void setDestinationPackage(String destinationPackage) {
        this.destinationPackage = destinationPackage;
    }

    protected void setPackageBaseList(List<String> packageBaseList) {
        this.packageBaseList = packageBaseList;
    }

    public void setOutputDirectory(File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }
}
