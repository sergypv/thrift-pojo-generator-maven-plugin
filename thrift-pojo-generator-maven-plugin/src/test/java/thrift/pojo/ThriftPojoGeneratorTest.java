package thrift.pojo;

import junit.framework.Assert;
import org.apache.maven.project.MavenProject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import thrift.pojo.test.pojo.package1.*;
import thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo;
import thrift.pojo.test.testdata.included.package1.*;
import thrift.pojo.test.testdata.included.package2.SimpleStructPackage2;

import static org.mockito.Mockito.*;

/**
 * Test the thrift pojo generator. It is not straight forward to test if a generated class is valid. It is easier to
 * test first that the generator in fact generate them againts a predefined set of files, and then (knowing that the
 * expected files are what the generator produces) test those templates
 */
public class ThriftPojoGeneratorTest {
    private static PojoMapEntryComparatorInterface genericValueComparator;
    private static PojoMapEntryComparatorInterface mapValueComparator;
    private static PojoMapEntryKeyGeneratorInterface genericKeyGenerator;
    private static PojoMapEntryKeyGeneratorInterface mapKeyGenerator;
    private static PojoMapEntryKeyGeneratorInterface mapOtherPackKeyGenerator;

    @BeforeClass
    public static void setup() {
        genericValueComparator = new PojoMapEntryComparatorInterface<Object, Object>() {
            @Override
            public boolean isEquals(Object mapValue, Object pojoMapValue) {
                return mapValue.equals(pojoMapValue);
            }
        };
        mapValueComparator = new PojoMapEntryComparatorInterface<MapValue, MapValuePojo>() {
            @Override
            public boolean isEquals(MapValue mapValue, MapValuePojo pojoMapValue) {
                return mapValue.getValue() == pojoMapValue.getValue();
            }
        };

        genericKeyGenerator = new PojoMapEntryKeyGeneratorInterface<Object, Object>() {
            @Override
            public Object getPojoKey(Object key) {
                return key;
            }
        };

        mapKeyGenerator = new PojoMapEntryKeyGeneratorInterface<MapKey, MapKeyPojo>() {
            @Override
            public MapKeyPojo getPojoKey(MapKey key) {
                return new MapKeyPojo(key.getKey());
            }
        };

        mapOtherPackKeyGenerator = new PojoMapEntryKeyGeneratorInterface<SimpleStructPackage2,SimpleStructPackage2Pojo>(){
            @Override
            public SimpleStructPackage2Pojo getPojoKey(SimpleStructPackage2 key) {
                return new SimpleStructPackage2Pojo(key.getName());
            }
        };
    }

    @Test
    public void testGeneratorProduceFiles() throws Exception {
        ThriftPojoGeneratorMock thriftPojoGenerator = new ThriftPojoGeneratorMock();

        MavenProject mavenProjectMock = mock(MavenProject.class);
        thriftPojoGenerator.setProject(mavenProjectMock);
        File outputFile = mock(File.class);
        thriftPojoGenerator.setOutputDirectory(outputFile);
        thriftPojoGenerator.setOutputPostfix("Pojo");
        thriftPojoGenerator.setInterfaceName("java.io.Serializable");
        thriftPojoGenerator.setDestinationPackage("thrift.pojo.test.pojo");

        List<String> sourceList = new ArrayList<String>();
        sourceList.add("src/test/resources/thrift-java");
        thriftPojoGenerator.setSources(sourceList);

        List<String> packageList = new ArrayList<String>();
        packageList.add("thrift.pojo.test.testdata.included");
        thriftPojoGenerator.setPackageBaseList(packageList);

        // Stub testing methods
        doNothing().when(mavenProjectMock).addCompileSourceRoot(anyString());
        when(outputFile.getAbsolutePath()).thenReturn("None");

        // Execute and verify
        thriftPojoGenerator.execute();

        // Verify files
        Assert.assertEquals(18, thriftPojoGenerator.fileToContentMap.size());

        String[] a = {"java"};
        String expectedFilesPath = "src/test/expectedFiles";
        Iterator<File> expectedFiles = FileUtils.iterateFiles(new File(expectedFilesPath), a, true);
        while (expectedFiles.hasNext()) {
            File expectedFile = expectedFiles.next();
            String fileContent = thriftPojoGenerator.fileToContentMap.get(expectedFile.getPath().substring(expectedFilesPath.length() + 1));
            Assert.assertNotNull(fileContent);
            Assert.assertEquals(FileUtils.readFileToString(expectedFile), fileContent);
        }
    }

    private class ThriftPojoGeneratorMock extends ThriftPojoGenerator {
        protected Map<String, String> fileToContentMap = new HashMap<String, String>();

        @Override
        protected void writeClass(String folder, String fileName, String content) throws IOException {
            fileToContentMap.put(folder + "/" + fileName, content);
        }
    }

    @Test
    public void testProducedBridgeConversionForPlainTypes() throws Exception {
        SimpleStruct simpleStruct = new SimpleStruct("string1");
        SimpleStructPackage2 simpleStructPackage2 = new SimpleStructPackage2("string2");
        ObjectInnerStruct objectInnerStruct = new ObjectInnerStruct("string3", simpleStruct, simpleStructPackage2);
        TestTypesStruct typeStruct = new TestTypesStruct("string4", null, (short) 1, 100, 1000l, true, (byte) 1, 300d, EnumStruct.VAL1, simpleStruct, objectInnerStruct);

        // Conversion should return the same value than provided
        TestTypesStructPojo testTypesStructPojo = TestTypesStructPojoBridge.getPojoRepresentation(typeStruct);
        assertProducedPojo(typeStruct, testTypesStructPojo);
        assertProducedPojo(TestTypesStructPojoBridge.getRemoteRepresentation(testTypesStructPojo), testTypesStructPojo);
        // TODO: Get the Collection functionality up, running and tested
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
        assertMapEquals(testMapStruct.getRefOtherPackage(), testMapStructPojo.getRefOtherPackage(), mapOtherPackKeyGenerator, genericValueComparator);
    }

    private <K, V, PK, PV> void assertMapEquals(Map<K, V> map, Map<PK, PV> mapPojo, PojoMapEntryKeyGeneratorInterface<K, PK> keyGeneratorInterface, PojoMapEntryComparatorInterface<V, PV> pojoMapEntryComparatorInterface) {
        Assert.assertEquals(map.size(), mapPojo.size());
        for (Map.Entry<K, V> mapEntry : map.entrySet()) {
            PV pojoValue = mapPojo.get(keyGeneratorInterface.getPojoKey(mapEntry.getKey()));
            Assert.assertNotNull(pojoValue);
            Assert.assertTrue(pojoMapEntryComparatorInterface.isEquals(mapEntry.getValue(), pojoValue));
        }
    }

    private void assertProducedPojo(TestTypesStruct typeStruct, TestTypesStructPojo testTypesStructPojo) {
        Assert.assertEquals(typeStruct.getSimpleString(), testTypesStructPojo.getSimpleString());
        Assert.assertNull(testTypesStructPojo.getNonRequiredString());
        Assert.assertEquals(typeStruct.getNumber16b(), testTypesStructPojo.getNumber16b());
        Assert.assertEquals(typeStruct.getNumber32b(), testTypesStructPojo.getNumber32b());
        Assert.assertEquals(typeStruct.getNumber64b(), testTypesStructPojo.getNumber64b());
        Assert.assertEquals(typeStruct.isBooleanValue(), testTypesStructPojo.getBooleanValue());
        Assert.assertEquals(typeStruct.getByteValue(), testTypesStructPojo.getByteValue());
        Assert.assertEquals(typeStruct.getDoubleValue(), testTypesStructPojo.getDoubleValue());
        Assert.assertEquals(typeStruct.getEnumType().name(), testTypesStructPojo.getEnumType().name());
        Assert.assertEquals(typeStruct.getRef().getName(), testTypesStructPojo.getRef().getName());
        Assert.assertEquals(typeStruct.getComposedStruct().getStringVariable(), testTypesStructPojo.getComposedStruct().getStringVariable());
        Assert.assertEquals(typeStruct.getComposedStruct().getInnerStruct().getName(), testTypesStructPojo.getComposedStruct().getInnerStruct().getName());
        Assert.assertEquals(typeStruct.getComposedStruct().getInnerStructPackage2().getName(), testTypesStructPojo.getComposedStruct().getInnerStructPackage2().getName());
    }


    private interface PojoMapEntryComparatorInterface<V, PV> {
        public boolean isEquals(V mapValue, PV pojoMapValue);
    }

    private interface PojoMapEntryKeyGeneratorInterface<K, PK> {
        public PK getPojoKey(K key);
    }
}