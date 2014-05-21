package org.disges.thrift.plugin.testdata.pojo.package1;

public class TestListStructPojoBridge {

	public static TestListStructPojo getPojoRepresentation(org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct remote) {
		return new TestListStructPojo(getPojoListRepresentationSimpleList(remote.simpleList), getPojoListRepresentationRefList(remote.refList), getPojoListRepresentationRefOtherPackageList(remote.refOtherPackageList));
	}

	public static org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct getRemoteRepresentation(TestListStructPojo pojo){
		return new org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct(getRemoteListRepresentationSimpleList(pojo.getSimpleList()), getRemoteListRepresentationRefList(pojo.getRefList()), getRemoteListRepresentationRefOtherPackageList(pojo.getRefOtherPackageList()));
	}

	public static java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct> getRemoteRepresentationCollection(java.util.Set<TestListStructPojo> pojoSet) {
		java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct> remoteRepresentationCollection = new java.util.HashSet<org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct>();
		for (TestListStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestListStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<TestListStructPojo> getPojoRepresentationCollection(java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct> pojoSet) {
		java.util.Set<TestListStructPojo> pojoRepresentationCollection = new java.util.HashSet<TestListStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestListStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct> getRemoteRepresentationCollection(java.util.List<TestListStructPojo> pojoSet) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct> remoteRepresentationCollection = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct>();
		for (TestListStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestListStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<TestListStructPojo> getPojoRepresentationCollection(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct> pojoSet) {
		java.util.List<TestListStructPojo> pojoRepresentationCollection = new java.util.ArrayList<TestListStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.TestListStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestListStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	private static java.util.List<java.lang.Integer> getPojoListRepresentationSimpleList(java.util.List<java.lang.Integer> list) {
		java.util.List<java.lang.Integer> newList = new java.util.ArrayList<java.lang.Integer>(list.size());
		for (java.lang.Integer listEntry : list) {
			newList.add(listEntry);
		}

		return newList;
	}

	private static java.util.List<java.lang.Integer> getRemoteListRepresentationSimpleList(java.util.List<java.lang.Integer> list) {
		java.util.List<java.lang.Integer> newList = new java.util.ArrayList<java.lang.Integer>(list.size());
		for (java.lang.Integer listEntry : list) {
			newList.add(listEntry);
		}

		return newList;
	}

	private static java.util.List<org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojo> getPojoListRepresentationRefList(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct> list) {
		java.util.List<org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojo> newList = new java.util.ArrayList<org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojo>(list.size());
		for (org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct listEntry : list) {
			newList.add(org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojoBridge.getPojoRepresentation(listEntry));
		}

		return newList;
	}

	private static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct> getRemoteListRepresentationRefList(java.util.List<org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojo> list) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct> newList = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct>(list.size());
		for (org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojo listEntry : list) {
			newList.add(org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojoBridge.getRemoteRepresentation(listEntry));
		}

		return newList;
	}

	private static java.util.List<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo> getPojoListRepresentationRefOtherPackageList(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2> list) {
		java.util.List<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo> newList = new java.util.ArrayList<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo>(list.size());
		for (org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2 listEntry : list) {
			newList.add(org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2PojoBridge.getPojoRepresentation(listEntry));
		}

		return newList;
	}

	private static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2> getRemoteListRepresentationRefOtherPackageList(java.util.List<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo> list) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2> newList = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2>(list.size());
		for (org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo listEntry : list) {
			newList.add(org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2PojoBridge.getRemoteRepresentation(listEntry));
		}

		return newList;
	}


}