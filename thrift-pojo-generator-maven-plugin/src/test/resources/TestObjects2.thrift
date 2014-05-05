namespace java thrift.pojo.test.testdata.included.package2

struct SimpleStructPackage2 {
    1: required string name;
}

struct ObjectInnerStructPackage2 {
    1: required string stringVariable;
    2: required SimpleStructPackage2 innerStruct;
}
