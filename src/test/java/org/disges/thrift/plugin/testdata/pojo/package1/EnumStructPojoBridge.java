package org.disges.thrift.plugin.testdata.pojo.package1;

public class EnumStructPojoBridge {
	public static EnumStructPojo getPojoRepresentation(org.disges.thrift.plugin.testdata.objects.included.package1.EnumStruct type) {
		return EnumStructPojo.valueOf(type.name());
	}

	public static org.disges.thrift.plugin.testdata.objects.included.package1.EnumStruct getRemoteRepresentation(EnumStructPojo pojoEnum) {
		return org.disges.thrift.plugin.testdata.objects.included.package1.EnumStruct.valueOf(pojoEnum.name());
	}
}