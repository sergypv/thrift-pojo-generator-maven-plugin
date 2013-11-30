package thrift.pojo;

import java.util.Map;

import org.stringtemplate.v4.STGroup;

public interface PojoInterface {
	public String getPojoClass(STGroup templateGroup, Map<String, PojoInterface> thirftNameToPojoClassMap);

	public String getClassPackage();

	public String getClassName();

	public String getRemoteName();
}