package thrift.pojo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.project.MavenProject;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;

/**
 * @goal generate-sources
 * @phase generate-sources
 */
public class ThriftPojoGenerator extends AbstractMojo {

	/**
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 * @since 1.0
	 */
	private MavenProject project;

	/**
	 * @parameter
	 * @required
	 */
	private List<String> sources;

	/**
	 * @parameter default-value="target/generated-sources"
	 * @required
	 */
	private File outputDirectory;

	/**
	 * @parameter default-value="Pojo"
	 */
	private String outputPostfix = null;

	/**
	 * @parameter
	 */
	private String interfaceName = null;

	/**
	 * @parameter
	 */
	private String destinationPackage = null;

	/**
	 * @parameter
	 */
	private List<String> packageBaseList = null;

	@Override
	public void execute() {
		try {
			StringTemplateGroup template = getTemplate();
			JavaDocBuilder docBuilder = getBuilder();

			getLog().info(
					String.format("Executing ThriftPojoGenerator. Sources [ %s ]; outputDirectory [ %s ]; postfix [ %s ]; inteface [ %s ]", sources,
							outputDirectory, outputPostfix, interfaceName));

			generate(template, docBuilder);

			project.addCompileSourceRoot(outputDirectory.getAbsolutePath());
		} catch (Exception e) {
			getLog().error("General error", e);
		}
	}

	private void generate(StringTemplateGroup template, JavaDocBuilder docBuilder) throws Exception {
		Map<String, PojoClass> thirftNameToPojoClassMap = new HashMap<String, PojoClass>();

		for (JavaClass jc : docBuilder.getClasses()) {
			if (jc.isA("org.apache.thrift.TBase") && !jc.isInterface() && !jc.isInner() && getSource(jc) != null) {
				PojoClass pojo = generateBuilderFor(jc, template);
				if (pojo != null) {
					thirftNameToPojoClassMap.put(pojo.getRemoteClass(), pojo);
				}
			}
		}

		for (Map.Entry<String, PojoClass> entry : thirftNameToPojoClassMap.entrySet()) {
			getLog().info("Writing pojo: " + entry.getValue().toString());
			writeClass(entry.getValue().getClassPackage().replaceAll("\\.", "/"), entry.getValue().getClassName() + ".java",
					entry.getValue().getPojoClass(template, thirftNameToPojoClassMap));
		}

	}

	private JavaDocBuilder getBuilder() {
		JavaDocBuilder docBuilder = new JavaDocBuilder();
		for (String r : sources) {
			docBuilder.addSourceTree(new File(r));
		}

		return docBuilder;
	}

	private StringTemplateGroup getTemplate() throws IOException {
		StringTemplateGroup templates;
		InputStream is = ThriftPojoGenerator.class.getClassLoader().getResourceAsStream("thriftPojo.stg");
		try {
			templates = new StringTemplateGroup(new InputStreamReader(is));
		} finally {
			is.close();
		}

		return templates;
	}

	private PojoClass generateBuilderFor(JavaClass javaClass, StringTemplateGroup template) throws IOException {

		for (JavaMethod method : javaClass.getMethods()) {
			if (isAllArgumentsConstructor(javaClass, method)) {
				PojoClass pojo = new PojoClass(getGeneratedClassPackage(javaClass), getPojoClassName(javaClass.getName()), javaClass.getFullyQualifiedName(),
						interfaceName);
				for (JavaParameter p : method.getParameters()) {
					pojo.addParameter(p.getType().toGenericString(), p.getName());
				}

				return pojo;
			}
		}

		return null;
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

	private void writeClass(String folder, String fileName, String content) throws IOException {
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
}
