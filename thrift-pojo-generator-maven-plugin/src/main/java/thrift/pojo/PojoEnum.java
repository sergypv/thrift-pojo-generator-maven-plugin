package thrift.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

public class PojoEnum implements PojoInterface {
	private static final String POJO_BUILDER = "enumBuilder";
	private static final String BRIDGE_BUILDER = "enumBridgeBuilder";
	private static final String POJO_PACKAGE = "packageName";
	private static final String POJO_REMOTE_ENUM = "pojoEnumName";
	private static final String POJO_ENUM = "enumName";
	private static final String POJO_TYPES = "types";

	private String enumPackage;
	private String enumName;
	private String remoteName;
	private List<String> types = new ArrayList<String>();

	public PojoEnum(String enumPackage, String enumName, String remoteEnum) {
		super();
		this.enumPackage = enumPackage;
		this.enumName = enumName;
		this.remoteName = remoteEnum;
	}

	public void addType(String type) {
		types.add(type);
	}

	@Override
	public String getPojoClass(STGroup templateGroup, Map<String, PojoInterface> thirftNameToPojoClassMap) {
		ST template = templateGroup.getInstanceOf(POJO_BUILDER);

		populateTemplateParams(template);

		return template.render();
	}

	@Override
	public String getBridgeClass(STGroup templateGroup, Map<String, PojoInterface> thirftNameToPojoClassMap) {
		ST template = templateGroup.getInstanceOf(BRIDGE_BUILDER);

		populateTemplateParams(template);

		return template.render();
	}
	
	private void populateTemplateParams(ST template) {
		template.add(POJO_PACKAGE, enumPackage);
		template.add(POJO_ENUM, remoteName);
		template.add(POJO_REMOTE_ENUM, enumName);
		template.add(POJO_TYPES, types);	
	}

	@Override
	public String getClassPackage() {
		return enumPackage;
	}

	@Override
	public String getClassName() {
		return enumName;
	}

	@Override
	public String getRemoteName() {
		return remoteName;
	}

	public void setRemoteName(String remoteName) {
		this.remoteName = remoteName;
	}

	@Override
	public String toString() {
		return "PojoEnum [enumPackage=" + enumPackage + ", enumName=" + enumName + ", remoteName=" + remoteName + ", types=" + types + "]";
	}
}
