package thrift.pojo.test.pojo.package1;

public class TestListStructPojoBridge {

	public static TestListStructPojo getPojoRepresentation(thrift.pojo.test.testdata.included.package1.TestListStruct remote) {
		return new TestListStructPojo(remote.simpleList, remote.refList, remote.refOtherPackageList);
	}

	public static thrift.pojo.test.testdata.included.package1.TestListStruct getRemoteRepresentation(TestListStructPojo pojo){
		return new thrift.pojo.test.testdata.included.package1.TestListStruct(pojo.getSimpleList(), pojo.getRefList(), pojo.getRefOtherPackageList());
	}

	public static java.util.Set<thrift.pojo.test.testdata.included.package1.TestListStruct> getRemoteRepresentationCollection(java.util.Set<TestListStructPojo> pojoSet) {
		java.util.Set<thrift.pojo.test.testdata.included.package1.TestListStruct> remoteRepresentationCollection = new java.util.HashSet<thrift.pojo.test.testdata.included.package1.TestListStruct>();
		for (TestListStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestListStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<TestListStructPojo> getPojoRepresentationCollection(java.util.Set<thrift.pojo.test.testdata.included.package1.TestListStruct> pojoSet) {
		java.util.Set<TestListStructPojo> pojoRepresentationCollection = new java.util.HashSet<TestListStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.TestListStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestListStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<thrift.pojo.test.testdata.included.package1.TestListStruct> getRemoteRepresentationCollection(java.util.List<TestListStructPojo> pojoSet) {
		java.util.List<thrift.pojo.test.testdata.included.package1.TestListStruct> remoteRepresentationCollection = new java.util.ArrayList<thrift.pojo.test.testdata.included.package1.TestListStruct>();
		for (TestListStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestListStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<TestListStructPojo> getPojoRepresentationCollection(java.util.List<thrift.pojo.test.testdata.included.package1.TestListStruct> pojoSet) {
		java.util.List<TestListStructPojo> pojoRepresentationCollection = new java.util.ArrayList<TestListStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.TestListStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestListStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}