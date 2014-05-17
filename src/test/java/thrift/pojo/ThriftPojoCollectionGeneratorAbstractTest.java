package thrift.pojo;

import thrift.pojo.test.pojo.package1.SimpleStructPojo;
import thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo;
import thrift.pojo.test.testdata.included.package1.SimpleStruct;
import thrift.pojo.test.testdata.included.package2.SimpleStructPackage2;

public abstract class ThriftPojoCollectionGeneratorAbstractTest {
    protected static PojoKeyGeneratorInterface genericKeyGenerator;
    protected static PojoKeyGeneratorInterface otherPackKeyGenerator;
    protected static PojoKeyGeneratorInterface simpleKeyGenerator;

    public static void setup() {
        genericKeyGenerator = new PojoKeyGeneratorInterface<Object, Object>() {
            @Override
            public Object getPojoKey(Object key) {
                return key;
            }
        };

        otherPackKeyGenerator = new PojoKeyGeneratorInterface<SimpleStructPackage2, SimpleStructPackage2Pojo>() {
            @Override
            public SimpleStructPackage2Pojo getPojoKey(SimpleStructPackage2 key) {
                return new SimpleStructPackage2Pojo(key.getName());
            }
        };

        simpleKeyGenerator = new PojoKeyGeneratorInterface<SimpleStruct, SimpleStructPojo>() {
            @Override
            public SimpleStructPojo getPojoKey(SimpleStruct key) {
                return new SimpleStructPojo(key.getName());
            }
        };


    }

    protected interface PojoComparatorInterface<V, PV> {
        public boolean isEquals(V mapValue, PV pojoMapValue);
    }

    protected interface PojoKeyGeneratorInterface<K, PK> {
        public PK getPojoKey(K key);
    }

}
