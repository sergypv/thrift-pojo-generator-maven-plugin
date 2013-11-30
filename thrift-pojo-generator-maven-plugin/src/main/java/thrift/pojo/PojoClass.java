package thrift.pojo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

public class PojoClass implements PojoInterface {
	private static final String POJO_BUILDER = "builder";
	private static final String POJO_PACKAGE = "packageName";
	private static final String POJO_CLASS = "pojoClassName";
	private static final String POJO_PARAMETERS = "parameters";
	private static final String POJO_INTEFACE = "pojoInteface";
	private static final String POJO_INTEFACE_ACTIVE = "pojoIntefaceActive";
	private static final String REMOTE_CLASS = "remoteClass";

	private List<PojoParameter> parameters = new LinkedList<PojoParameter>();
	private String classPackage;
	private String className;
	private String remoteName;
	private String interfaceName;

	public PojoClass(String classPackage, String className, String remoteClass, String interfaceName) {
		super();
		this.classPackage = classPackage;
		this.className = className;
		this.remoteName = remoteClass;
		this.interfaceName = interfaceName;
	}

	public void addParameter(String type, String paramName) {
		parameters.add(new PojoParameter(type, paramName));
	}

	@Override
	public String getPojoClass(STGroup templateGroup, Map<String, PojoInterface> thirftNameToPojoClassMap) {
		ST template = templateGroup.getInstanceOf(POJO_BUILDER);
		remmapParameters(thirftNameToPojoClassMap);

		template.add(POJO_PACKAGE, classPackage);
		template.add(POJO_CLASS, className);
		template.add(REMOTE_CLASS, remoteName);
		template.add(POJO_PARAMETERS, parameters);
		template.add(POJO_INTEFACE_ACTIVE, (this.interfaceName != null && !this.interfaceName.isEmpty()));
		template.add(POJO_INTEFACE, interfaceName);

		return template.render();
	}

	private void remmapParameters(Map<String, PojoInterface> thirftNameToPojoClassMap) {
		for (PojoParameter parameter : parameters) {
			PojoInterface pojo = thirftNameToPojoClassMap.get(parameter.getType());
			if (pojo != null) {
				parameter.setPojoType(pojo.getClassPackage() + "." + pojo.getClassName());
				if (pojo instanceof PojoEnum) {
					parameter.setEnumPojo(true);
				} else {
					parameter.setPojo(true);
				}
			}
		}
	}

	public List<PojoParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<PojoParameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String getClassPackage() {
		return classPackage;
	}

	public void setClassPackage(String classPackage) {
		this.classPackage = classPackage;
	}

	@Override
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRemoteName() {
		return remoteName;
	}

	public void setRemoteName(String remoteClass) {
		this.remoteName = remoteClass;
	}

	@Override
	public String toString() {
		return "PojoClass [remoteClass=" + remoteName + ", classPackage=" + classPackage + ", className=" + className + ", interfaceName=" + interfaceName
				+ ", parameters=" + parameters + "]";
	}
}
