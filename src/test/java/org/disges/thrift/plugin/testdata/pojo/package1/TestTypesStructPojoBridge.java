package org.disges.thrift.plugin.testdata.pojo.package1;

public class TestTypesStructPojoBridge {

	public static TestTypesStructPojo getPojoRepresentation(org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct remote) {
		return new TestTypesStructPojo(remote.simpleString, remote.nonRequiredString, remote.number16b, remote.number32b, remote.number64b, remote.booleanValue, remote.byteValue, remote.doubleValue, org.disges.thrift.plugin.testdata.pojo.package1.EnumStructPojoBridge.getPojoRepresentation(remote.enumType), org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojoBridge.getPojoRepresentation(remote.ref), org.disges.thrift.plugin.testdata.pojo.package1.ObjectInnerStructPojoBridge.getPojoRepresentation(remote.composedStruct));
	}

	public static org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct getRemoteRepresentation(TestTypesStructPojo pojo){
		return new org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct(pojo.getSimpleString(), pojo.getNonRequiredString(), pojo.getNumber16b(), pojo.getNumber32b(), pojo.getNumber64b(), pojo.getBooleanValue(), pojo.getByteValue(), pojo.getDoubleValue(), org.disges.thrift.plugin.testdata.pojo.package1.EnumStructPojoBridge.getRemoteRepresentation(pojo.getEnumType()), org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojoBridge.getRemoteRepresentation(pojo.getRef()), org.disges.thrift.plugin.testdata.pojo.package1.ObjectInnerStructPojoBridge.getRemoteRepresentation(pojo.getComposedStruct()));
	}

	public static java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct> getRemoteRepresentationCollection(java.util.Set<TestTypesStructPojo> pojoSet) {
		java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct> remoteRepresentationCollection = new java.util.HashSet<org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct>();
		for (TestTypesStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestTypesStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<TestTypesStructPojo> getPojoRepresentationCollection(java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct> pojoSet) {
		java.util.Set<TestTypesStructPojo> pojoRepresentationCollection = new java.util.HashSet<TestTypesStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestTypesStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct> getRemoteRepresentationCollection(java.util.List<TestTypesStructPojo> pojoSet) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct> remoteRepresentationCollection = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct>();
		for (TestTypesStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestTypesStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<TestTypesStructPojo> getPojoRepresentationCollection(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct> pojoSet) {
		java.util.List<TestTypesStructPojo> pojoRepresentationCollection = new java.util.ArrayList<TestTypesStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestTypesStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}