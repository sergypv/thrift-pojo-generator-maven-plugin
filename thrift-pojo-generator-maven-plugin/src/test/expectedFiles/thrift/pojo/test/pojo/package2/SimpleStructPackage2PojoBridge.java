package thrift.pojo.test.pojo.package2;

public class SimpleStructPackage2PojoBridge {

	public static SimpleStructPackage2Pojo getPojoRepresentation(thrift.pojo.test.testdata.included.package2.SimpleStructPackage2 remote) {
		return new SimpleStructPackage2Pojo(remote.name);
	}

	public static thrift.pojo.test.testdata.included.package2.SimpleStructPackage2 getRemoteRepresentation(SimpleStructPackage2Pojo pojo){
		return new thrift.pojo.test.testdata.included.package2.SimpleStructPackage2(pojo.getName());
	}

	public static java.util.Set<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> getRemoteRepresentationCollection(java.util.Set<SimpleStructPackage2Pojo> pojoSet) {
		java.util.Set<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> remoteRepresentationCollection = new java.util.HashSet<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2>();
		for (SimpleStructPackage2Pojo pojo : pojoSet) {
			remoteRepresentationCollection.add(SimpleStructPackage2PojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<SimpleStructPackage2Pojo> getPojoRepresentationCollection(java.util.Set<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> pojoSet) {
		java.util.Set<SimpleStructPackage2Pojo> pojoRepresentationCollection = new java.util.HashSet<SimpleStructPackage2Pojo>();
		for (thrift.pojo.test.testdata.included.package2.SimpleStructPackage2 remote : pojoSet) {
			pojoRepresentationCollection.add(SimpleStructPackage2PojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> getRemoteRepresentationCollection(java.util.List<SimpleStructPackage2Pojo> pojoSet) {
		java.util.List<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> remoteRepresentationCollection = new java.util.ArrayList<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2>();
		for (SimpleStructPackage2Pojo pojo : pojoSet) {
			remoteRepresentationCollection.add(SimpleStructPackage2PojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<SimpleStructPackage2Pojo> getPojoRepresentationCollection(java.util.List<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> pojoSet) {
		java.util.List<SimpleStructPackage2Pojo> pojoRepresentationCollection = new java.util.ArrayList<SimpleStructPackage2Pojo>();
		for (thrift.pojo.test.testdata.included.package2.SimpleStructPackage2 remote : pojoSet) {
			pojoRepresentationCollection.add(SimpleStructPackage2PojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}