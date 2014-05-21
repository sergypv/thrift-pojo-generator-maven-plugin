package org.disges.thrift.plugin.testdata.pojo.package2;

public class ObjectInnerStructPackage2PojoBridge {

	public static ObjectInnerStructPackage2Pojo getPojoRepresentation(org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2 remote) {
		return new ObjectInnerStructPackage2Pojo(remote.stringVariable, org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2PojoBridge.getPojoRepresentation(remote.innerStruct));
	}

	public static org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2 getRemoteRepresentation(ObjectInnerStructPackage2Pojo pojo){
		return new org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2(pojo.getStringVariable(), org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2PojoBridge.getRemoteRepresentation(pojo.getInnerStruct()));
	}

	public static java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2> getRemoteRepresentationCollection(java.util.Set<ObjectInnerStructPackage2Pojo> pojoSet) {
		java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2> remoteRepresentationCollection = new java.util.HashSet<org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2>();
		for (ObjectInnerStructPackage2Pojo pojo : pojoSet) {
			remoteRepresentationCollection.add(ObjectInnerStructPackage2PojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<ObjectInnerStructPackage2Pojo> getPojoRepresentationCollection(java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2> pojoSet) {
		java.util.Set<ObjectInnerStructPackage2Pojo> pojoRepresentationCollection = new java.util.HashSet<ObjectInnerStructPackage2Pojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2 remote : pojoSet) {
			pojoRepresentationCollection.add(ObjectInnerStructPackage2PojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2> getRemoteRepresentationCollection(java.util.List<ObjectInnerStructPackage2Pojo> pojoSet) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2> remoteRepresentationCollection = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2>();
		for (ObjectInnerStructPackage2Pojo pojo : pojoSet) {
			remoteRepresentationCollection.add(ObjectInnerStructPackage2PojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<ObjectInnerStructPackage2Pojo> getPojoRepresentationCollection(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2> pojoSet) {
		java.util.List<ObjectInnerStructPackage2Pojo> pojoRepresentationCollection = new java.util.ArrayList<ObjectInnerStructPackage2Pojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package2.ObjectInnerStructPackage2 remote : pojoSet) {
			pojoRepresentationCollection.add(ObjectInnerStructPackage2PojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}