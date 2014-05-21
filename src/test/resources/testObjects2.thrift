namespace java org.disges.thrift.plugin.testdata.objects.included.package2

struct SimpleStructPackage2 {
    1: required string name;
}

struct ObjectInnerStructPackage2 {
    1: required string stringVariable;
    2: required SimpleStructPackage2 innerStruct;
}
