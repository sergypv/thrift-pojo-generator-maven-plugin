package thrift.pojo;

import junit.framework.Assert;
import org.disges.thrift.plugin.testdata.objects.included.package1.EnumStruct;
import org.disges.thrift.plugin.testdata.objects.included.package1.ObjectInnerStruct;
import org.disges.thrift.plugin.testdata.objects.included.package1.SimpleStruct;
import org.disges.thrift.plugin.testdata.objects.included.package1.TestTypesStruct;
import org.disges.thrift.plugin.testdata.objects.included.package2.SimpleStructPackage2;
import org.disges.thrift.plugin.testdata.pojo.package1.TestTypesStructPojo;
import org.disges.thrift.plugin.testdata.pojo.package1.TestTypesStructPojoBridge;
import org.junit.Test;

public class ThriftPojoGeneratorPlainTypesTest {
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
