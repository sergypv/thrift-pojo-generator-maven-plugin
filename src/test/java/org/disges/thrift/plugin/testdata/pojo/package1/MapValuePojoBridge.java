package org.disges.thrift.plugin.testdata.pojo.package1;

public class MapValuePojoBridge {

	public static MapValuePojo getPojoRepresentation(org.disges.thrift.plugin.testdata.objects.included.package1.MapValue remote) {
		return new MapValuePojo(remote.value);
	}

	public static org.disges.thrift.plugin.testdata.objects.included.package1.MapValue getRemoteRepresentation(MapValuePojo pojo){
		return new org.disges.thrift.plugin.testdata.objects.included.package1.MapValue(pojo.getValue());
	}

	public static java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> getRemoteRepresentationCollection(java.util.Set<MapValuePojo> pojoSet) {
		java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> remoteRepresentationCollection = new java.util.HashSet<org.disges.thrift.plugin.testdata.objects.included.package1.MapValue>();
		for (MapValuePojo pojo : pojoSet) {
			remoteRepresentationCollection.add(MapValuePojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<MapValuePojo> getPojoRepresentationCollection(java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> pojoSet) {
		java.util.Set<MapValuePojo> pojoRepresentationCollection = new java.util.HashSet<MapValuePojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.MapValue remote : pojoSet) {
			pojoRepresentationCollection.add(MapValuePojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> getRemoteRepresentationCollection(java.util.List<MapValuePojo> pojoSet) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> remoteRepresentationCollection = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package1.MapValue>();
		for (MapValuePojo pojo : pojoSet) {
			remoteRepresentationCollection.add(MapValuePojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<MapValuePojo> getPojoRepresentationCollection(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> pojoSet) {
		java.util.List<MapValuePojo> pojoRepresentationCollection = new java.util.ArrayList<MapValuePojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.MapValue remote : pojoSet) {
			pojoRepresentationCollection.add(MapValuePojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

}