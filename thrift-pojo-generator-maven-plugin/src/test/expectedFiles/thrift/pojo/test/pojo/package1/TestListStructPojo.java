package thrift.pojo.test.pojo.package1;

public class TestListStructPojo implements java.io.Serializable {
	public enum Fields{
		SimpleList, RefList, RefOtherPackageList
	};

		
	private java.util.List<java.lang.Integer> simpleList;
		
	private java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> refList;
		
	private java.util.List<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> refOtherPackageList;

	public TestListStructPojo() {
		super();
	}

	public TestListStructPojo(java.util.List<java.lang.Integer> simpleList,java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> refList,java.util.List<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> refOtherPackageList) {
		super();

		this.simpleList = simpleList;
		this.refList = refList;
		this.refOtherPackageList = refOtherPackageList;
	}


	// Getters and Setters
	public java.util.List<java.lang.Integer> getSimpleList() {
	       return simpleList;
	}
	public void setSimpleList(java.util.List<java.lang.Integer> simpleList) {
	       this.simpleList = simpleList;
	}
	public java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> getRefList() {
	       return refList;
	}
	public void setRefList(java.util.List<thrift.pojo.test.testdata.included.package1.SimpleStruct> refList) {
	       this.refList = refList;
	}
	public java.util.List<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> getRefOtherPackageList() {
	       return refOtherPackageList;
	}
	public void setRefOtherPackageList(java.util.List<thrift.pojo.test.testdata.included.package2.SimpleStructPackage2> refOtherPackageList) {
	       this.refOtherPackageList = refOtherPackageList;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestListStructPojo that = (TestListStructPojo) o;

        if (simpleList != null ? !simpleList.equals(that.simpleList) : that.simpleList != null) return false;
        if (refList != null ? !refList.equals(that.refList) : that.refList != null) return false;
        if (refOtherPackageList != null ? !refOtherPackageList.equals(that.refOtherPackageList) : that.refOtherPackageList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (simpleList != null ? (simpleList.hashCode() * 31) : 0);

        result = 31 * result + (refList != null ? refList.hashCode() : 0);
        result = 31 * result + (refOtherPackageList != null ? refOtherPackageList.hashCode() : 0);

        return result;
    }
}