package thrift.pojo;

import junit.framework.Assert;
import org.apache.maven.project.MavenProject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;

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
        String expectedFilesPath = "src/test/resources/expectedFiles";
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

    }
//    @Test
//    public void testProducedFilesAsExpected() throws Exception {
////        ThriftPojoGeneratorMock thriftPojoGenerator = new ThriftPojoGeneratorMock();
//        ThriftPojoGenerator thriftPojoGenerator = new ThriftPojoGenerator();
//
//        MavenProject mavenProjectMock = mock(MavenProject.class);
//        thriftPojoGenerator.setProject(mavenProjectMock);
////        File outputFile = mock(File.class);
//        thriftPojoGenerator.setOutputDirectory(new File("/Users/sergio/git/thrift-pojo-generator-maven-plugin/thrift-pojo-generator-maven-plugin/src/test/resources/expectedFiles"));
//        thriftPojoGenerator.setOutputPostfix("Pojo");
//        thriftPojoGenerator.setInterfaceName("java.io.Serializable");
//        thriftPojoGenerator.setDestinationPackage("thrift.pojo.test.pojo");
//
//        List<String> sourceList = new ArrayList<String>();
//        sourceList.add("src/test/resources/thrift-java");
//        thriftPojoGenerator.setSources(sourceList);
//
//        List<String> packageList = new ArrayList<String>();
//        packageList.add("thrift.pojo.test.testdata.included");
//        thriftPojoGenerator.setPackageBaseList(packageList);
//
//        // Stub testing methods
//        doNothing().when(mavenProjectMock).addCompileSourceRoot(anyString());
//
//        // Execute and verify
//        thriftPojoGenerator.execute();
////        verify(thriftPojoGenerator).writeClass("","","");
//    }
}