package thrift.pojo;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import thrift.pojo.test.pojo.package1.TestSetStructPojo;
import thrift.pojo.test.pojo.package1.TestSetStructPojoBridge;
import thrift.pojo.test.testdata.included.package1.SimpleStruct;
import thrift.pojo.test.testdata.included.package1.TestSetStruct;
import thrift.pojo.test.testdata.included.package2.SimpleStructPackage2;

import java.util.HashSet;
import java.util.Set;

public class ThriftPojoCollectionGeneratorSetTest extends ThriftPojoCollectionGeneratorAbstractTest {
    @BeforeClass
    public static void setup() {
        ThriftPojoCollectionGeneratorAbstractTest.setup();
    }

    @Test
    public void testProducedLists() {
        Set<Integer> simpleList = new HashSet<Integer>();
        simpleList.add(100);
        simpleList.add(200);

        Set<SimpleStruct> refList = new HashSet<SimpleStruct>();
        refList.add(new SimpleStruct("a1"));
        refList.add(new SimpleStruct("a2"));

        Set<SimpleStructPackage2> refOtherPackageList = new HashSet<SimpleStructPackage2>();
        refOtherPackageList.add(new SimpleStructPackage2("b1"));
        refOtherPackageList.add(new SimpleStructPackage2("b2"));

        TestSetStruct testSetStruct = new TestSetStruct(simpleList, refList, refOtherPackageList);

        TestSetStructPojo testSetStructPojo = TestSetStructPojoBridge.getPojoRepresentation(testSetStruct);
        assertProducedPojo(testSetStruct, testSetStructPojo);
        assertProducedPojo(TestSetStructPojoBridge.getRemoteRepresentation(testSetStructPojo), testSetStructPojo);
    }

    private void assertProducedPojo(TestSetStruct testSetStruct, TestSetStructPojo testSetStructPojo){
        assertListEquals(testSetStruct.getSimpleList(), testSetStructPojo.getSimpleList(), genericKeyGenerator);
        assertListEquals(testSetStruct.getRefList(), testSetStructPojo.getRefList(), simpleKeyGenerator);
        assertListEquals(testSetStruct.getRefOtherPackageList(), testSetStructPojo.getRefOtherPackageList(), otherPackKeyGenerator);
    }

    private <L, LP> void assertListEquals(Set<L> set, Set<LP> setPojo, PojoKeyGeneratorInterface<L, LP> keyGenerator) {
        Assert.assertEquals(set.size(), setPojo.size());
        for(L setEntry : set){
            Assert.assertTrue(setPojo.contains(keyGenerator.getPojoKey(setEntry)));
        }
    }
}
