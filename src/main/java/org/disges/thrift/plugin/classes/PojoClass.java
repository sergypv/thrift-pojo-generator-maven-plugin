package org.disges.thrift.plugin.classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.disges.thrift.plugin.parameters.PojoParameter;
import org.disges.thrift.plugin.parameters.PojoParameterList;
import org.disges.thrift.plugin.parameters.PojoParameterMap;
import org.disges.thrift.plugin.parameters.PojoParameterSet;

public class PojoClass implements PojoInterface {
	private static final String POJO_BUILDER = "builder";
	private static final String BRIDGE_BUILDER = "bridgeBuilder";
	private static final String POJO_PACKAGE = "packageName";
	private static final String POJO_CLASS = "pojoClassName";
	private static final String POJO_PARAMETERS = "parameters";
	private static final String POJO_INTERFACE = "pojoInterface";
	private static final String POJO_INTERFACE_ACTIVE = "pojoInterfaceActive";
	private static final String REMOTE_CLASS = "remoteClass";
	private static final String POJO_SUPERCLASS_ACTIVE = "pojoSuperclassActive";
	private static final String POJO_SUPERCLASS = "pojoSuperclass";
    private static final String POJO_INCLUDE_FIELDS_ENUM = "pojoIncludeFieldsEnum";

    private List<PojoParameter> parameters = new LinkedList<PojoParameter>();
	private String classPackage;
	private String className;
	private String remoteName;
	private String interfaceName;
	private String pojoSuperclas;
    private boolean includeFieldsEnum = false;

	public PojoClass(String classPackage, String className, String remoteClass, String interfaceName, String pojoSuperclas, boolean includeFieldsEnum) {
		super();
		this.classPackage = classPackage;
		this.className = className;
		this.remoteName = remoteClass;
		this.interfaceName = interfaceName;
		this.pojoSuperclas = pojoSuperclas;
        this.includeFieldsEnum = includeFieldsEnum;
	}

	public void addParameter(String type, String paramName) {
		parameters.add(new PojoParameter(type, paramName));
	}

	public void addMapParameter(String type, String paramName) {
		parameters.add(new PojoParameterMap(type, paramName));
	}

    public void addListParameter(String type, String paramName){
        parameters.add(new PojoParameterList(type,paramName));
    }

    public void addSetParameter(String type, String paramName){
        parameters.add(new PojoParameterSet(type,paramName));
    }

	@Override
	public String getPojoClass(STGroup templateGroup, Map<String, PojoInterface> thirftNameToPojoClassMap) {
		ST template = templateGroup.getInstanceOf(POJO_BUILDER);

		remmapParameters(thirftNameToPojoClassMap);
		populateTemplateParams(template);
		template.add(POJO_INTERFACE_ACTIVE, (this.interfaceName != null && !this.interfaceName.isEmpty()));
		template.add(POJO_INTERFACE, interfaceName);
		template.add(POJO_SUPERCLASS_ACTIVE, (pojoSuperclas != null && !pojoSuperclas.isEmpty()));
		template.add(POJO_SUPERCLASS, pojoSuperclas);
        template.add(POJO_INCLUDE_FIELDS_ENUM, includeFieldsEnum);

		return template.render();
	}

	@Override
	public String getBridgeClass(STGroup templateGroup, Map<String, PojoInterface> thirftNameToPojoClassMap) {
		ST template = templateGroup.getInstanceOf(BRIDGE_BUILDER);

		remmapParameters(thirftNameToPojoClassMap);
		populateTemplateParams(template);

		return template.render();
	}

	private void populateTemplateParams(ST template) {
		template.add(POJO_PACKAGE, classPackage);
		template.add(POJO_CLASS, className);
		template.add(REMOTE_CLASS, remoteName);
		template.add(POJO_PARAMETERS, parameters);
	}

	private void remmapParameters(Map<String, PojoInterface> thirftNameToPojoClassMap) {
		for (PojoParameter parameter : parameters) {
			parameter.remmapParameters(thirftNameToPojoClassMap);
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
