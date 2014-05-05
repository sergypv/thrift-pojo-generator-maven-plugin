include "testObjects2.thrift"
include "testObjects3.thrift"

namespace java thrift.pojo.test.testdata.included.package1

enum EnumStruct {
    VAL1 = 1,
    VAL2 = 2
}

struct SimpleStruct {
    1: required string name;
}

struct ObjectInnerStruct {
    1: required string stringVariable;
    2: required SimpleStruct innerStruct;
    3: required testObjects2.SimpleStructPackage2 innerStructPackage2;
}

struct TestTypesStruct {
    1: required string simpleString;
    2: string nonRequiredString;
    3: i16 number16b;
    4: i32 number32b;
    5: i64 number64b;
    6: bool booleanValue;
    7: byte byteValue;
    8: double doubleValue;
    9: required EnumStruct enumType;
    10: required SimpleStruct ref;
    11: required ObjectInnerStruct composedStruct;
}

struct MapKey {
    1: required string key;
}

struct MapValue {
    1: required i32 value;
}

struct TestMapStruct {
    1: required map<MapKey,MapValue> refMap;
    2: required map<i32,MapValue> refValueMap;
    3: required map<MapKey,i32> refKeyMap;
    4: required map<string,i32> simpleMap;
    5: required map<testObjects2.SimpleStructPackage2, i32> refOtherPackage;
}