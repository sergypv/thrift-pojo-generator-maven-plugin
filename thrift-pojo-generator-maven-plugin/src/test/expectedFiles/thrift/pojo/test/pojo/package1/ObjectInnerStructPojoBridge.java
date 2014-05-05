package thrift.pojo.test.pojo.package1;

public class ObjectInnerStructPojoBridge {

	public static ObjectInnerStructPojo getPojoRepresentation(thrift.pojo.test.testdata.included.package1.ObjectInnerStruct remote) {
		return new ObjectInnerStructPojo(remote.stringVariable, thrift.pojo.test.pojo.package1.SimpleStructPojoBridge.getPojoRepresentation(remote.innerStruct), thrift.pojo.test.pojo.package2.SimpleStructPackage2PojoBridge.getPojoRepresentation(remote.innerStructPackage2));
	}

	public static thrift.pojo.test.testdata.included.package1.ObjectInnerStruct getRemoteRepresentation(ObjectInnerStructPojo pojo){
		return new thrift.pojo.test.testdata.included.package1.ObjectInnerStruct(pojo.getStringVariable(), thrift.pojo.test.pojo.package1.SimpleStructPojoBridge.getRemoteRepresentation(pojo.getInnerStruct()), thrift.pojo.test.pojo.package2.SimpleStructPackage2PojoBridge.getRemoteRepresentation(pojo.getInnerStructPackage2()));
	}

	public static java.util.Set<thrift.pojo.test.testdata.included.package1.ObjectInnerStruct> getRemoteRepresentationCollection(java.util.Set<ObjectInnerStructPojo> pojoSet) {
		java.util.Set<thrift.pojo.test.testdata.included.package1.ObjectInnerStruct> remoteRepresentationCollection = new java.util.HashSet<thrift.pojo.test.testdata.included.package1.ObjectInnerStruct>();
		for (ObjectInnerStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(ObjectInnerStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<ObjectInnerStructPojo> getPojoRepresentationCollection(java.util.Set<thrift.pojo.test.testdata.included.package1.ObjectInnerStruct> pojoSet) {
		java.util.Set<ObjectInnerStructPojo> pojoRepresentationCollection = new java.util.HashSet<ObjectInnerStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.ObjectInnerStruct remote : pojoSet) {
			pojoRepresentationCollection.add(ObjectInnerStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<thrift.pojo.test.testdata.included.package1.ObjectInnerStruct> getRemoteRepresentationCollection(java.util.List<ObjectInnerStructPojo> pojoSet) {
		java.util.List<thrift.pojo.test.testdata.included.package1.ObjectInnerStruct> remoteRepresentationCollection = new java.util.ArrayList<thrift.pojo.test.testdata.included.package1.ObjectInnerStruct>();
		for (ObjectInnerStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(ObjectInnerStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<ObjectInnerStructPojo> getPojoRepresentationCollection(java.util.List<thrift.pojo.test.testdata.included.package1.ObjectInnerStruct> pojoSet) {
		java.util.List<ObjectInnerStructPojo> pojoRepresentationCollection = new java.util.ArrayList<ObjectInnerStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.ObjectInnerStruct remote : pojoSet) {
			pojoRepresentationCollection.add(ObjectInnerStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}