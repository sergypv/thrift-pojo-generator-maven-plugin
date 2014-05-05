package thrift.pojo.test.pojo.package1;

public class EnumStructPojoBridge {
	public static EnumStructPojo getPojoRepresentation(thrift.pojo.test.testdata.included.package1.EnumStruct type) {
		return EnumStructPojo.valueOf(type.name());
	}

	public static thrift.pojo.test.testdata.included.package1.EnumStruct getRemoteRepresentation(EnumStructPojo pojoEnum) {
		return thrift.pojo.test.testdata.included.package1.EnumStruct.valueOf(pojoEnum.name());
	}
}