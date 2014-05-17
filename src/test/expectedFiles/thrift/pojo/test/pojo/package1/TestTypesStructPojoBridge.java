package thrift.pojo.test.pojo.package1;

public class TestTypesStructPojoBridge {

	public static TestTypesStructPojo getPojoRepresentation(thrift.pojo.test.testdata.included.package1.TestTypesStruct remote) {
		return new TestTypesStructPojo(remote.simpleString, remote.nonRequiredString, remote.number16b, remote.number32b, remote.number64b, remote.booleanValue, remote.byteValue, remote.doubleValue, thrift.pojo.test.pojo.package1.EnumStructPojoBridge.getPojoRepresentation(remote.enumType), thrift.pojo.test.pojo.package1.SimpleStructPojoBridge.getPojoRepresentation(remote.ref), thrift.pojo.test.pojo.package1.ObjectInnerStructPojoBridge.getPojoRepresentation(remote.composedStruct));
	}

	public static thrift.pojo.test.testdata.included.package1.TestTypesStruct getRemoteRepresentation(TestTypesStructPojo pojo){
		return new thrift.pojo.test.testdata.included.package1.TestTypesStruct(pojo.getSimpleString(), pojo.getNonRequiredString(), pojo.getNumber16b(), pojo.getNumber32b(), pojo.getNumber64b(), pojo.getBooleanValue(), pojo.getByteValue(), pojo.getDoubleValue(), thrift.pojo.test.pojo.package1.EnumStructPojoBridge.getRemoteRepresentation(pojo.getEnumType()), thrift.pojo.test.pojo.package1.SimpleStructPojoBridge.getRemoteRepresentation(pojo.getRef()), thrift.pojo.test.pojo.package1.ObjectInnerStructPojoBridge.getRemoteRepresentation(pojo.getComposedStruct()));
	}

	public static java.util.Set<thrift.pojo.test.testdata.included.package1.TestTypesStruct> getRemoteRepresentationCollection(java.util.Set<TestTypesStructPojo> pojoSet) {
		java.util.Set<thrift.pojo.test.testdata.included.package1.TestTypesStruct> remoteRepresentationCollection = new java.util.HashSet<thrift.pojo.test.testdata.included.package1.TestTypesStruct>();
		for (TestTypesStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestTypesStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<TestTypesStructPojo> getPojoRepresentationCollection(java.util.Set<thrift.pojo.test.testdata.included.package1.TestTypesStruct> pojoSet) {
		java.util.Set<TestTypesStructPojo> pojoRepresentationCollection = new java.util.HashSet<TestTypesStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.TestTypesStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestTypesStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<thrift.pojo.test.testdata.included.package1.TestTypesStruct> getRemoteRepresentationCollection(java.util.List<TestTypesStructPojo> pojoSet) {
		java.util.List<thrift.pojo.test.testdata.included.package1.TestTypesStruct> remoteRepresentationCollection = new java.util.ArrayList<thrift.pojo.test.testdata.included.package1.TestTypesStruct>();
		for (TestTypesStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestTypesStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<TestTypesStructPojo> getPojoRepresentationCollection(java.util.List<thrift.pojo.test.testdata.included.package1.TestTypesStruct> pojoSet) {
		java.util.List<TestTypesStructPojo> pojoRepresentationCollection = new java.util.ArrayList<TestTypesStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.TestTypesStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestTypesStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}