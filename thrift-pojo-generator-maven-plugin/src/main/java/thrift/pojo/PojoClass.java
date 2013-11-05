package thrift.pojo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

public class PojoClass {
	private static final String POJO_BUILDER = "builder";
	private static final String POJO_PACKAGE = "packageName";
	private static final String POJO_CLASS = "pojoClassName";
	private static final String POJO_PARAMETERS = "parameters";
	private static final String REMOTE_CLASS = "remoteClass";

	private List<PojoParameter> parameters = new LinkedList<PojoParameter>();
	private String classPackage;
	private String className;
	private String remoteClass;

	public PojoClass(String classPackage, String className, String remoteClass) {
		super();
		this.classPackage = classPackage;
		this.className = className;
		this.remoteClass = remoteClass;
	}

	public void addParameter(String type, String paramName) {
		parameters.add(new PojoParameter(type, paramName));
	}

	public String getPojoClass(StringTemplateGroup templateGroup, Map<String, PojoClass> thirftNameToPojoClassMap) {
		StringTemplate template = templateGroup.getInstanceOf(POJO_BUILDER);
		remmapParameters(thirftNameToPojoClassMap);

		template.setAttribute(POJO_PACKAGE, classPackage);
		template.setAttribute(POJO_CLASS, className);
		template.setAttribute(REMOTE_CLASS, remoteClass);
		template.setAttribute(POJO_PARAMETERS, parameters);

		return template.toString();
	}

	private void remmapParameters(Map<String, PojoClass> thirftNameToPojoClassMap) {
		for (PojoParameter parameter : parameters) {
			PojoClass pojo = thirftNameToPojoClassMap.get(parameter.getType());
			if (pojo != null) {
				parameter.setPojoType(pojo.getClassPackage() + "." + pojo.getClassName());
				parameter.setPojo(true);
			}
		}
	}

	public List<PojoParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<PojoParameter> parameters) {
		this.parameters = parameters;
	}

	public String getClassPackage() {
		return classPackage;
	}

	public void setClassPackage(String classPackage) {
		this.classPackage = classPackage;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRemoteClass() {
		return remoteClass;
	}

	public void setRemoteClass(String remoteClass) {
		this.remoteClass = remoteClass;
	}
}
