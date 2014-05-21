package org.disges.thrift.plugin.testdata.pojo.package1;

public class SimpleStructPojoBridge {

	public static SimpleStructPojo getPojoRepresentation(org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct remote) {
		return new SimpleStructPojo(remote.name);
	}

	public static org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct getRemoteRepresentation(SimpleStructPojo pojo){
		return new org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct(pojo.getName());
	}

	public static java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct> getRemoteRepresentationCollection(java.util.Set<SimpleStructPojo> pojoSet) {
		java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct> remoteRepresentationCollection = new java.util.HashSet<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct>();
		for (SimpleStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(SimpleStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<SimpleStructPojo> getPojoRepresentationCollection(java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct> pojoSet) {
		java.util.Set<SimpleStructPojo> pojoRepresentationCollection = new java.util.HashSet<SimpleStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct remote : pojoSet) {
			pojoRepresentationCollection.add(SimpleStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct> getRemoteRepresentationCollection(java.util.List<SimpleStructPojo> pojoSet) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct> remoteRepresentationCollection = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct>();
		for (SimpleStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(SimpleStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<SimpleStructPojo> getPojoRepresentationCollection(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct> pojoSet) {
		java.util.List<SimpleStructPojo> pojoRepresentationCollection = new java.util.ArrayList<SimpleStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct remote : pojoSet) {
			pojoRepresentationCollection.add(SimpleStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}