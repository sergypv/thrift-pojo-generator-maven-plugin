package org.disges.thrift.plugin.testdata.pojo.package1;

public class TestSetStructPojo implements java.io.Serializable {
	public enum Fields{
		SimpleList, RefList, RefOtherPackageList
	};

	private java.util.Set<java.lang.Integer> simpleList;
	private java.util.Set<org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojo> refList;
	private java.util.Set<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo> refOtherPackageList;

	public TestSetStructPojo() {
		super();
	}

	public TestSetStructPojo(java.util.Set<java.lang.Integer> simpleList,java.util.Set<org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojo> refList,java.util.Set<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo> refOtherPackageList) {
		super();

		this.simpleList = simpleList;
		this.refList = refList;
		this.refOtherPackageList = refOtherPackageList;
	}


	// Getters and Setters
	public java.util.Set<java.lang.Integer> getSimpleList() {
	       return simpleList;
	}
	public void setSimpleList(java.util.Set<java.lang.Integer> simpleList) {
	       this.simpleList = simpleList;
	}
	public java.util.Set<org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojo> getRefList() {
	       return refList;
	}
	public void setRefList(java.util.Set<org.disges.thrift.plugin.testdata.pojo.package1.SimpleStructPojo> refList) {
	       this.refList = refList;
	}
	public java.util.Set<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo> getRefOtherPackageList() {
	       return refOtherPackageList;
	}
	public void setRefOtherPackageList(java.util.Set<org.disges.thrift.plugin.testdata.pojo.package2.SimpleStructPackage2Pojo> refOtherPackageList) {
	       this.refOtherPackageList = refOtherPackageList;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestSetStructPojo that = (TestSetStructPojo) o;

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