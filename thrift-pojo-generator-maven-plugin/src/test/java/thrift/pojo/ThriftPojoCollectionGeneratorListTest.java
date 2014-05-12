package thrift.pojo;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import thrift.pojo.test.pojo.package1.TestListStructPojo;
import thrift.pojo.test.pojo.package1.TestListStructPojoBridge;
import thrift.pojo.test.testdata.included.package1.SimpleStruct;
import thrift.pojo.test.testdata.included.package1.TestListStruct;
import thrift.pojo.test.testdata.included.package2.SimpleStructPackage2;

import java.util.ArrayList;
import java.util.List;

public class ThriftPojoCollectionGeneratorListTest extends ThriftPojoCollectionGeneratorAbstractTest {
    @BeforeClass
    public static void setup() {
        ThriftPojoCollectionGeneratorAbstractTest.setup();
    }

    @Test
    public void testProducedLists() {
        List<Integer> simpleList = new ArrayList<Integer>();
        simpleList.add(100);
        simpleList.add(200);

        List<SimpleStruct> refList = new ArrayList<SimpleStruct>();
        refList.add(new SimpleStruct("a1"));
        refList.add(new SimpleStruct("a2"));

        List<SimpleStructPackage2> refOtherPackageList = new ArrayList<SimpleStructPackage2>();
        refOtherPackageList.add(new SimpleStructPackage2("b1"));
        refOtherPackageList.add(new SimpleStructPackage2("b2"));

        TestListStruct testListStruct = new TestListStruct(simpleList, refList, refOtherPackageList);

        TestListStructPojo testListStructPojo = TestListStructPojoBridge.getPojoRepresentation(testListStruct);
        assertProducedPojo(testListStruct, testListStructPojo);
        assertProducedPojo(TestListStructPojoBridge.getRemoteRepresentation(testListStructPojo), testListStructPojo);
    }

    private void assertProducedPojo(TestListStruct testListStruct, TestListStructPojo testListStructPojo){
        assertListEquals(testListStruct.getSimpleList(), testListStructPojo.getSimpleList(), genericKeyGenerator);
        assertListEquals(testListStruct.getRefList(), testListStructPojo.getRefList(), simpleKeyGenerator);
        assertListEquals(testListStruct.getRefOtherPackageList(), testListStructPojo.getRefOtherPackageList(), otherPackKeyGenerator);

    }

    private <L, LP> void assertListEquals(List<L> list, List<LP> listPojo, PojoKeyGeneratorInterface<L, LP> keyGeneratorInterface) {
        Assert.assertEquals(list.size(), listPojo.size());
        for (L object : list) {
            listPojo.contains(keyGeneratorInterface.getPojoKey(object));
        }
    }
}
