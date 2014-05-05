package thrift.pojo;

import junit.framework.Assert;
import org.apache.maven.project.MavenProject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import thrift.pojo.test.pojo.package1.TestTypesStructPojo;
import thrift.pojo.test.pojo.package1.TestTypesStructPojoBridge;
import thrift.pojo.test.testdata.included.package1.EnumStruct;
import thrift.pojo.test.testdata.included.package1.ObjectInnerStruct;
import thrift.pojo.test.testdata.included.package1.SimpleStruct;
import thrift.pojo.test.testdata.included.package1.TestTypesStruct;
import thrift.pojo.test.testdata.included.package2.SimpleStructPackage2;

import static org.mockito.Mockito.*;

/**
 * Test the thrift pojo generator. It is not straight forward to test if a generated class is valid. It is easier to
 * test first that the generator in fact generate them againts a predefined set of files, and then (knowing that the
 * expected files are what the generator produces) test those templates
 */
public class ThriftPojoGeneratorTest {

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
    public void testProducedFilesAsExpected() throws Exception {
        SimpleStruct simpleStruct = new SimpleStruct("string1");
        SimpleStructPackage2 simpleStructPackage2 = new SimpleStructPackage2("string2");
        ObjectInnerStruct objectInnerStruct = new ObjectInnerStruct("string3", simpleStruct, simpleStructPackage2);
        TestTypesStruct typeStruct = new TestTypesStruct("string4", null, (short) 1, 100, 1000l, true, (byte) 1, 300d, EnumStruct.VAL1, simpleStruct, objectInnerStruct);

        // Conversion should return the same value than provided
        TestTypesStructPojo testTypesStructPojo = TestTypesStructPojoBridge.getPojoRepresentation(typeStruct);
        assertProducedPojo(typeStruct, testTypesStructPojo);
        assertProducedPojo(TestTypesStructPojoBridge.getRemoteRepresentation(testTypesStructPojo), testTypesStructPojo);
        // TODO: Test Maps
        // TODO: Get the Collection functionality up, running and tested
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
}