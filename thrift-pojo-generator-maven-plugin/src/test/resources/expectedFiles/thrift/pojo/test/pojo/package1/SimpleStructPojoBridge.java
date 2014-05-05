package thrift.pojo.test.pojo.package1;

public class SimpleStructPojoBridge {

	public static SimpleStructPojo getPojoRepresentation(thrift.pojo.test.testdata.included.package1.SimpleStruct remote) {
		return new SimpleStructPojo(remote.name);
	}

	public static thrift.pojo.test.testdata.included.package1.SimpleStruct getRemoteRepresentation(SimpleStructPojo pojo){
		return new thrift.pojo.test.testdata.included.package1.SimpleStruct(pojo.getName());
	}

	public static java.util.Set<thrift.pojo.test.testdata.included.package1.SimpleStruct> getRemoteRepresentationCollection(java.util.Set<SimpleStructPojo> pojoSet) {
		java.util.Set<thrift.pojo.test.testdata.included.package1.SimpleStruct> remoteRepresentationCollection = new java.util.HashSet<thrift.pojo.test.testdata.included.package1.SimpleStruct>();
		for (SimpleStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(SimpleStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<SimpleStructPojo> getPojoRepresentationCollection(java.util.Set<thrift.pojo.test.testdata.included.package1.SimpleStruct> pojoSet) {
		java.util.Set<SimpleStructPojo> pojoRepresentationCollection = new java.util.HashSet<SimpleStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.SimpleStruct remote : pojoSet) {
			pojoRepresentationCollection.add(SimpleStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> getRemoteRepresentationCollection(java.util.List<SimpleStructPojo> pojoSet) {
		java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> remoteRepresentationCollection = new java.util.ArrayList<thrift.pojo.test.testdata.included.package1.SimpleStruct>();
		for (SimpleStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(SimpleStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<SimpleStructPojo> getPojoRepresentationCollection(java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> pojoSet) {
		java.util.List<SimpleStructPojo> pojoRepresentationCollection = new java.util.ArrayList<SimpleStructPojo>();
		for (thrift.pojo.test.testdata.included.package1.SimpleStruct remote : pojoSet) {
			pojoRepresentationCollection.add(SimpleStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}