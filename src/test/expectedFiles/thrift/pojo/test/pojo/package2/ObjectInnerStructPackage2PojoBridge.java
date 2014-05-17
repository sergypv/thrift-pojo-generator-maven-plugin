package thrift.pojo.test.pojo.package2;

public class ObjectInnerStructPackage2PojoBridge {

	public static ObjectInnerStructPackage2Pojo getPojoRepresentation(thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2 remote) {
		return new ObjectInnerStructPackage2Pojo(remote.stringVariable, thrift.pojo.test.pojo.package2.SimpleStructPackage2PojoBridge.getPojoRepresentation(remote.innerStruct));
	}

	public static thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2 getRemoteRepresentation(ObjectInnerStructPackage2Pojo pojo){
		return new thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2(pojo.getStringVariable(), thrift.pojo.test.pojo.package2.SimpleStructPackage2PojoBridge.getRemoteRepresentation(pojo.getInnerStruct()));
	}

	public static java.util.Set<thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2> getRemoteRepresentationCollection(java.util.Set<ObjectInnerStructPackage2Pojo> pojoSet) {
		java.util.Set<thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2> remoteRepresentationCollection = new java.util.HashSet<thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2>();
		for (ObjectInnerStructPackage2Pojo pojo : pojoSet) {
			remoteRepresentationCollection.add(ObjectInnerStructPackage2PojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<ObjectInnerStructPackage2Pojo> getPojoRepresentationCollection(java.util.Set<thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2> pojoSet) {
		java.util.Set<ObjectInnerStructPackage2Pojo> pojoRepresentationCollection = new java.util.HashSet<ObjectInnerStructPackage2Pojo>();
		for (thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2 remote : pojoSet) {
			pojoRepresentationCollection.add(ObjectInnerStructPackage2PojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2> getRemoteRepresentationCollection(java.util.List<ObjectInnerStructPackage2Pojo> pojoSet) {
		java.util.List<thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2> remoteRepresentationCollection = new java.util.ArrayList<thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2>();
		for (ObjectInnerStructPackage2Pojo pojo : pojoSet) {
			remoteRepresentationCollection.add(ObjectInnerStructPackage2PojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<ObjectInnerStructPackage2Pojo> getPojoRepresentationCollection(java.util.List<thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2> pojoSet) {
		java.util.List<ObjectInnerStructPackage2Pojo> pojoRepresentationCollection = new java.util.ArrayList<ObjectInnerStructPackage2Pojo>();
		for (thrift.pojo.test.testdata.included.package2.ObjectInnerStructPackage2 remote : pojoSet) {
			pojoRepresentationCollection.add(ObjectInnerStructPackage2PojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}