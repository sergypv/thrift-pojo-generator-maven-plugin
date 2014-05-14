package thrift.pojo.test.pojo.package1;

public class TestSetStructPojoBridge {

	public static TestSetStructPojo getPojoRepresentation(thrift.pojo.test.testdata.included.package1.TestSetStruct remote) {
		return new TestSetStructPojo(getPojoSetRepresentationSimpleList(remote.simpleList), getPojoSetRepresentationRefList(remote.refList), getPojoSetRepresentationRefOtherPackageList(remote.refOtherPackageList));
	}

	public static thrift.pojo.test.testdata.included.package1.TestSetStruct getRemoteRepresentation(TestSetStructPojo pojo){
		return new thrift.pojo.test.testdata.included.package1.TestSetStruct(getRemoteSetRepresentationSimpleList(pojo.getSimpleList()), getRemoteSetRepresentationRefList(pojo.getRefList()), getRemoteSetRepresentationRefOtherPackageList(pojo.getRefOtherPackageList()));
	}

	public static java.util.Set<thrift.pojo.test.testdata.included.package1.TestSetStruct> getRemoteRepresentationCollection(java.util.Set<TestSetStructPojo> pojoSet) {
		java.util.Set<thrift.pojo.test.testdata.included.package1.TestSetStruct> remoteRepresentationCollection = new java.util.HashSet<thrift.pojo.test.testdata.included.package1.TestSetStruct>();
		for (TestSetStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestSetStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<TestSetStructPojo> getPojoRepresentationCollection(java.util.Set<thrift.pojo.test.testdata.included.package1.TestSetStruct> pojoSet) {
		java.util.Set<TestSetStructPojo> pojoRepresentationCollection = new java.util.HashSet<TestSetStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.TestSetStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestSetStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<thrift.pojo.test.testdata.included.package1.TestSetStruct> getRemoteRepresentationCollection(java.util.List<TestSetStructPojo> pojoSet) {
		java.util.List<thrift.pojo.test.testdata.included.package1.TestSetStruct> remoteRepresentationCollection = new java.util.ArrayList<thrift.pojo.test.testdata.included.package1.TestSetStruct>();
		for (TestSetStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestSetStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<TestSetStructPojo> getPojoRepresentationCollection(java.util.List<thrift.pojo.test.testdata.included.package1.TestSetStruct> pojoSet) {
		java.util.List<TestSetStructPojo> pojoRepresentationCollection = new java.util.ArrayList<TestSetStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.TestSetStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestSetStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	private static java.util.Set<java.lang.Integer> getPojoSetRepresentationSimpleList(java.util.Set<java.lang.Integer> set) {
		java.util.Set<java.lang.Integer> newSet = new java.util.HashSet<java.lang.Integer>(set.size());
		for (java.lang.Integer setEntry: set) {
			newSet.add(setEntry);
		}

		return newSet;
	}

	private static java.util.Set<java.lang.Integer> getRemoteSetRepresentationSimpleList(java.util.Set<java.lang.Integer> set) {
		java.util.Set<java.lang.Integer> newSet = new java.util.HashSet<java.lang.Integer>(set.size());
		for (java.lang.Integer setEntry : set) {
			newSet.add(setEntry);
		}

		return newSet;
	}

	private static java.util.Set<thrift.pojo.test.pojo.package1.SimpleStructPojo> getPojoSetRepresentationRefList(java.util.Set<thrift.pojo.test.testdata.included.package1.SimpleStruct> set) {
		java.util.Set<thrift.pojo.test.pojo.package1.SimpleStructPojo> newSet = new java.util.HashSet<thrift.pojo.test.pojo.package1.SimpleStructPojo>(set.size());
		for (thrift.pojo.test.testdata.included.package1.SimpleStruct setEntry: set) {
			newSet.add(thrift.pojo.test.pojo.package1.SimpleStructPojoBridge.getPojoRepresentation(setEntry));
		}

		return newSet;
	}

	private static java.util.Set<thrift.pojo.test.testdata.included.package1.SimpleStruct> getRemoteSetRepresentationRefList(java.util.Set<thrift.pojo.test.pojo.package1.SimpleStructPojo> set) {
		java.util.Set<thrift.pojo.test.testdata.included.package1.SimpleStruct> newSet = new java.util.HashSet<thrift.pojo.test.testdata.included.package1.SimpleStruct>(set.size());
		for (thrift.pojo.test.pojo.package1.SimpleStructPojo setEntry : set) {
			newSet.add(thrift.pojo.test.pojo.package1.SimpleStructPojoBridge.getRemoteRepresentation(setEntry));
		}

		return newSet;
	}

	private static java.util.Set<thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo> getPojoSetRepresentationRefOtherPackageList(java.util.Set<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> set) {
		java.util.Set<thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo> newSet = new java.util.HashSet<thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo>(set.size());
		for (thrift.pojo.test.testdata.included.package2.SimpleStructPackage2 setEntry: set) {
			newSet.add(thrift.pojo.test.pojo.package2.SimpleStructPackage2PojoBridge.getPojoRepresentation(setEntry));
		}

		return newSet;
	}

	private static java.util.Set<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> getRemoteSetRepresentationRefOtherPackageList(java.util.Set<thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo> set) {
		java.util.Set<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> newSet = new java.util.HashSet<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2>(set.size());
		for (thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo setEntry : set) {
			newSet.add(thrift.pojo.test.pojo.package2.SimpleStructPackage2PojoBridge.getRemoteRepresentation(setEntry));
		}

		return newSet;
	}


}