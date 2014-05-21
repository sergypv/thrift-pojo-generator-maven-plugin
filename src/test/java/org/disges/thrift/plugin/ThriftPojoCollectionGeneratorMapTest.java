package org.disges.thrift.plugin;

import junit.framework.Assert;
import org.disges.thrift.plugin.testdata.objects.included.package1.MapKey;
import org.disges.thrift.plugin.testdata.objects.included.package1.MapValue;
import org.disges.thrift.plugin.testdata.objects.included.package1.TestMapStruct;
import org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2;
import org.disges.thrift.plugin.testdata.pojo.package1.MapKeyPojo;
import org.disges.thrift.plugin.testdata.pojo.package1.MapValuePojo;
import org.disges.thrift.plugin.testdata.pojo.package1.TestMapStructPojo;
import org.disges.thrift.plugin.testdata.pojo.package1.TestMapStructPojoBridge;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ThriftPojoCollectionGeneratorMapTest extends ThriftPojoCollectionGeneratorAbstractTest {
    private static PojoComparatorInterface genericValueComparator;
    private static PojoComparatorInterface mapValueComparator;
    private static PojoKeyGeneratorInterface mapKeyGenerator;

    @BeforeClass
    public static void setup() {
        ThriftPojoCollectionGeneratorAbstractTest.setup();

        genericValueComparator = new PojoComparatorInterface<Object, Object>() {
            @Override
            public boolean isEquals(Object mapValue, Object pojoMapValue) {
                return mapValue.equals(pojoMapValue);
            }
        };
        mapValueComparator = new PojoComparatorInterface<MapValue, MapValuePojo>() {
            @Override
            public boolean isEquals(MapValue mapValue, MapValuePojo pojoMapValue) {
                return mapValue.getValue() == pojoMapValue.getValue();
            }
        };

        mapKeyGenerator = new PojoKeyGeneratorInterface<MapKey, MapKeyPojo>() {
            @Override
            public MapKeyPojo getPojoKey(MapKey key) {
                return new MapKeyPojo(key.getKey());
            }
        };
    }


    @Test
    public void testProducedBridgeConversionForMaps() throws Exception {
        Map<MapKey, MapValue> refMap = new HashMap<MapKey, MapValue>();
        refMap.put(new MapKey("key1"), new MapValue(1));

        Map<Integer, MapValue> refValueMap = new HashMap<Integer, MapValue>();
        refValueMap.put(2, new MapValue(2));

        Map<MapKey, Integer> refKeyMap = new HashMap<MapKey, Integer>();
        refKeyMap.put(new MapKey("key3"), 3);

        Map<String, Integer> simpleMap = new HashMap<String, Integer>();
        simpleMap.put("key4", 4);

        Map<SimpleStructPackage2, Integer> refOtherPackage = new HashMap<SimpleStructPackage2, Integer>();
        refOtherPackage.put(new SimpleStructPackage2("key5"), 5);

        TestMapStruct testMapStruct = new TestMapStruct(refMap, refValueMap, refKeyMap, simpleMap, refOtherPackage);

        TestMapStructPojo testMapStructPojo = TestMapStructPojoBridge.getPojoRepresentation(testMapStruct);
        assertProducedPojo(testMapStruct, testMapStructPojo);
        assertProducedPojo(TestMapStructPojoBridge.getRemoteRepresentation(testMapStructPojo), testMapStructPojo);
    }

    private void assertProducedPojo(TestMapStruct testMapStruct, TestMapStructPojo testMapStructPojo) {
        assertMapEquals(testMapStruct.getRefMap(), testMapStructPojo.getRefMap(), mapKeyGenerator, mapValueComparator);
        assertMapEquals(testMapStruct.getRefValueMap(), testMapStructPojo.getRefValueMap(), genericKeyGenerator, mapValueComparator);
        assertMapEquals(testMapStruct.getRefKeyMap(), testMapStructPojo.getRefKeyMap(), mapKeyGenerator, genericValueComparator);
        assertMapEquals(testMapStruct.getSimpleMap(), testMapStructPojo.getSimpleMap(), genericKeyGenerator, genericValueComparator);
        assertMapEquals(testMapStruct.getRefOtherPackage(), testMapStructPojo.getRefOtherPackage(), otherPackKeyGenerator, genericValueComparator);
    }

    private <K, V, PK, PV> void assertMapEquals(Map<K, V> map, Map<PK, PV> mapPojo, PojoKeyGeneratorInterface<K, PK> keyGeneratorInterface, PojoComparatorInterface<V, PV> pojoComparatorInterface) {
        Assert.assertEquals(map.size(), mapPojo.size());
        for (Map.Entry<K, V> mapEntry : map.entrySet()) {
            PV pojoValue = mapPojo.get(keyGeneratorInterface.getPojoKey(mapEntry.getKey()));
            Assert.assertNotNull(pojoValue);
            Assert.assertTrue(pojoComparatorInterface.isEquals(mapEntry.getValue(), pojoValue));
        }
    }
}
