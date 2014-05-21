package org.disges.thrift.plugin.testdata.pojo.package1;

public class TestMapStructPojoBridge {

	public static TestMapStructPojo getPojoRepresentation(org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct remote) {
		return new TestMapStructPojo(getPojoMapRepresentationRefMap(remote.refMap), getPojoMapRepresentationRefValueMap(remote.refValueMap), getPojoMapRepresentationRefKeyMap(remote.refKeyMap), getPojoMapRepresentationSimpleMap(remote.simpleMap), getPojoMapRepresentationRefOtherPackage(remote.refOtherPackage));
	}

	public static org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct getRemoteRepresentation(TestMapStructPojo pojo){
		return new org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct(getRemoteMapRepresentationRefMap(pojo.getRefMap()), getRemoteMapRepresentationRefValueMap(pojo.getRefValueMap()), getRemoteMapRepresentationRefKeyMap(pojo.getRefKeyMap()), getRemoteMapRepresentationSimpleMap(pojo.getSimpleMap()), getRemoteMapRepresentationRefOtherPackage(pojo.getRefOtherPackage()));
	}

	public static java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct> getRemoteRepresentationCollection(java.util.Set<TestMapStructPojo> pojoSet) {
		java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct> remoteRepresentationCollection = new java.util.HashSet<org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct>();
		for (TestMapStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestMapStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.Set<TestMapStructPojo> getPojoRepresentationCollection(java.util.Set<org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct> pojoSet) {
		java.util.Set<TestMapStructPojo> pojoRepresentationCollection = new java.util.HashSet<TestMapStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestMapStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	public static java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct> getRemoteRepresentationCollection(java.util.List<TestMapStructPojo> pojoSet) {
		java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct> remoteRepresentationCollection = new java.util.ArrayList<org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct>();
		for (TestMapStructPojo pojo : pojoSet) {
			remoteRepresentationCollection.add(TestMapStructPojoBridge.getRemoteRepresentation(pojo));
		}

		return remoteRepresentationCollection;
	}

	public static java.util.List<TestMapStructPojo> getPojoRepresentationCollection(java.util.List<org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct> pojoSet) {
		java.util.List<TestMapStructPojo> pojoRepresentationCollection = new java.util.ArrayList<TestMapStructPojo>();
		for (org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct remote : pojoSet) {
			pojoRepresentationCollection.add(TestMapStructPojoBridge.getPojoRepresentation(remote));
		}

		return pojoRepresentationCollection;
	}

	private static java.util.Map<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo> getPojoMapRepresentationRefMap(java.util.Map<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> map) {
		java.util.Map<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo> newMap = new java.util.HashMap<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo>(map.size());
		for (java.util.Map.Entry<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> entry : map.entrySet()) {
			newMap.put(org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojoBridge.getPojoRepresentation(entry.getKey()),
					   org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojoBridge.getPojoRepresentation(entry.getValue()));
		}

		return newMap;
	}

	private static java.util.Map<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> getRemoteMapRepresentationRefMap(java.util.Map<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo> map) {
		java.util.Map<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> newMap = new java.util.HashMap<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue>(map.size());
		for (java.util.Map.Entry<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo> entry : map.entrySet()) {
			newMap.put(org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojoBridge.getRemoteRepresentation(entry.getKey()),
					   org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojoBridge.getRemoteRepresentation(entry.getValue()));
		}

		return newMap;
	}

	private static java.util.Map<java.lang.Integer, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo> getPojoMapRepresentationRefValueMap(java.util.Map<java.lang.Integer, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> map) {
		java.util.Map<java.lang.Integer, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo> newMap = new java.util.HashMap<java.lang.Integer, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo>(map.size());
		for (java.util.Map.Entry<java.lang.Integer, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> entry : map.entrySet()) {
			newMap.put(entry.getKey(),
					   org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojoBridge.getPojoRepresentation(entry.getValue()));
		}

		return newMap;
	}

	private static java.util.Map<java.lang.Integer, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> getRemoteMapRepresentationRefValueMap(java.util.Map<java.lang.Integer, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo> map) {
		java.util.Map<java.lang.Integer, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue> newMap = new java.util.HashMap<java.lang.Integer, org.disges.thrift.plugin.testdata.objects.included.package1.MapValue>(map.size());
		for (java.util.Map.Entry<java.lang.Integer, org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo> entry : map.entrySet()) {
			newMap.put(entry.getKey(),
					   org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojoBridge.getRemoteRepresentation(entry.getValue()));
		}

		return newMap;
	}

	private static java.util.Map<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, java.lang.Integer> getPojoMapRepresentationRefKeyMap(java.util.Map<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, java.lang.Integer> map) {
		java.util.Map<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, java.lang.Integer> newMap = new java.util.HashMap<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, java.lang.Integer>(map.size());
		for (java.util.Map.Entry<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, java.lang.Integer> entry : map.entrySet()) {
			newMap.put(org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojoBridge.getPojoRepresentation(entry.getKey()),
					   entry.getValue());
		}

		return newMap;
	}

	private static java.util.Map<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, java.lang.Integer> getRemoteMapRepresentationRefKeyMap(java.util.Map<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, java.lang.Integer> map) {
		java.util.Map<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, java.lang.Integer> newMap = new java.util.HashMap<org.disges.thrift.plugin.testdata.objects.included.package1.MapKey, java.lang.Integer>(map.size());
		for (java.util.Map.Entry<org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo, java.lang.Integer> entry : map.entrySet()) {
			newMap.put(org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojoBridge.getRemoteRepresentation(entry.getKey()),
					   entry.getValue());
		}

		return newMap;
	}

	private static java.util.Map<java.lang.String, java.lang.Integer> getPojoMapRepresentationSimpleMap(java.util.Map<java.lang.String, java.lang.Integer> map) {
		java.util.Map<java.lang.String, java.lang.Integer> newMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(map.size());
		for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : map.entrySet()) {
			newMap.put(entry.getKey(),
					   entry.getValue());
		}

		return newMap;
	}

	private static java.util.Map<java.lang.String, java.lang.Integer> getRemoteMapRepresentationSimpleMap(java.util.Map<java.lang.String, java.lang.Integer> map) {
		java.util.Map<java.lang.String, java.lang.Integer> newMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(map.size());
		for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : map.entrySet()) {
			newMap.put(entry.getKey(),
					   entry.getValue());
		}

		return newMap;
	}

	private static java.util.Map<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo, java.lang.Integer> getPojoMapRepresentationRefOtherPackage(java.util.Map<org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2, java.lang.Integer> map) {
		java.util.Map<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo, java.lang.Integer> newMap = new java.util.HashMap<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo, java.lang.Integer>(map.size());
		for (java.util.Map.Entry<org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2, java.lang.Integer> entry : map.entrySet()) {
			newMap.put(org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2PojoBridge.getPojoRepresentation(entry.getKey()),
					   entry.getValue());
		}

		return newMap;
	}

	private static java.util.Map<org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2, java.lang.Integer> getRemoteMapRepresentationRefOtherPackage(java.util.Map<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo, java.lang.Integer> map) {
		java.util.Map<org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2, java.lang.Integer> newMap = new java.util.HashMap<org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2, java.lang.Integer>(map.size());
		for (java.util.Map.Entry<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo, java.lang.Integer> entry : map.entrySet()) {
			newMap.put(org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2PojoBridge.getRemoteRepresentation(entry.getKey()),
					   entry.getValue());
		}

		return newMap;
	}


}