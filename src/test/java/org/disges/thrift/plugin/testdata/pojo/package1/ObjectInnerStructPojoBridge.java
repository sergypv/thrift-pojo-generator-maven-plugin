package org.disges.thrift.plugin.testdata.pojo.package1;

public class ObjectInnerStructPojoBridge {

	public static ObjectInnerStructPojo getPojoRepresentation(org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct remote) {
		return new ObjectInnerStructPojo(remote.stringVariable, org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojoBridge.getPojoRepresentation(remote.innerStruct), org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2PojoBridge.getPojoRepresentation(remote.innerStructPackage2));
	}

	public static org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct getRemoteRepresentation(ObjectInnerStructPojo pojo){
		return new org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct(pojo.getStringVariable(), org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojoBridge.getRemoteRepresentation(pojo.getInnerStruct()), org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2PojoBridge.getRemoteRepresentation(pojo.getInnerStructPackage2()));
	}

	public static java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct> getRemoteRepresentationCollection(java.util.Set<ObjectInnerStructPojo> pojoSet) {
		java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct> remoteRepresentationCollection = new java.util.HashSet<org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct>();
		for (ObjectInnerStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(ObjectInnerStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<ObjectInnerStructPojo> getPojoRepresentationCollection(java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct> pojoSet) {
		java.util.Set<ObjectInnerStructPojo> pojoRepresentationCollection = new java.util.HashSet<ObjectInnerStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct remote : pojoSet) {
			pojoRepresentationCollection.add(ObjectInnerStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct> getRemoteRepresentationCollection(java.util.List<ObjectInnerStructPojo> pojoSet) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct> remoteRepresentationCollection = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct>();
		for (ObjectInnerStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(ObjectInnerStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<ObjectInnerStructPojo> getPojoRepresentationCollection(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct> pojoSet) {
		java.util.List<ObjectInnerStructPojo> pojoRepresentationCollection = new java.util.ArrayList<ObjectInnerStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct remote : pojoSet) {
			pojoRepresentationCollection.add(ObjectInnerStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}