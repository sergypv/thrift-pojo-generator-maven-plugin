package org.disges.thrift.plugin.testdata.pojo.package1;

public class MapKeyPojoBridge {

	public static MapKeyPojo getPojoRepresentation(org.disges.thrift.plugin.testdata.objects.included.package1.MapKey remote) {
		return new MapKeyPojo(remote.key);
	}

	public static org.disges.thrift.plugin.testdata.objects.included.package1.MapKey getRemoteRepresentation(MapKeyPojo pojo){
		return new org.disges.thrift.plugin.testdata.objects.included.package1.MapKey(pojo.getKey());
	}

	public static java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey> getRemoteRepresentationCollection(java.util.Set<MapKeyPojo> pojoSet) {
		java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey> remoteRepresentationCollection = new java.util.HashSet<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey>();
		for (MapKeyPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(MapKeyPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<MapKeyPojo> getPojoRepresentationCollection(java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey> pojoSet) {
		java.util.Set<MapKeyPojo> pojoRepresentationCollection = new java.util.HashSet<MapKeyPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.MapKey remote : pojoSet) {
			pojoRepresentationCollection.add(MapKeyPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey> getRemoteRepresentationCollection(java.util.List<MapKeyPojo> pojoSet) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey> remoteRepresentationCollection = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey>();
		for (MapKeyPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(MapKeyPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<MapKeyPojo> getPojoRepresentationCollection(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey> pojoSet) {
		java.util.List<MapKeyPojo> pojoRepresentationCollection = new java.util.ArrayList<MapKeyPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.MapKey remote : pojoSet) {
			pojoRepresentationCollection.add(MapKeyPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}