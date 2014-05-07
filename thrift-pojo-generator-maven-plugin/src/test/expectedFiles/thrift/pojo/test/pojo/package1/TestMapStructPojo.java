package thrift.pojo.test.pojo.package1;

public class TestMapStructPojo implements java.io.Serializable {
	public enum Fields{
		RefMap, RefValueMap, RefKeyMap, SimpleMap, RefOtherPackage
	};

	private java.util.Map<thrift.pojo.test.pojo.package1.MapKeyPojo, thrift.pojo.test.pojo.package1.MapValuePojo> refMap;
	private java.util.Map<java.lang.Integer, thrift.pojo.test.pojo.package1.MapValuePojo> refValueMap;
	private java.util.Map<thrift.pojo.test.pojo.package1.MapKeyPojo, java.lang.Integer> refKeyMap;
	private java.util.Map<java.lang.String, java.lang.Integer> simpleMap;
	private java.util.Map<thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo, java.lang.Integer> refOtherPackage;

	public TestMapStructPojo() {
		super();
	}

	public TestMapStructPojo(java.util.Map<thrift.pojo.test.pojo.package1.MapKeyPojo, thrift.pojo.test.pojo.package1.MapValuePojo> refMap,java.util.Map<java.lang.Integer, thrift.pojo.test.pojo.package1.MapValuePojo> refValueMap,java.util.Map<thrift.pojo.test.pojo.package1.MapKeyPojo, java.lang.Integer> refKeyMap,java.util.Map<java.lang.String, java.lang.Integer> simpleMap,java.util.Map<thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo, java.lang.Integer> refOtherPackage) {
		super();

		this.refMap = refMap;
		this.refValueMap = refValueMap;
		this.refKeyMap = refKeyMap;
		this.simpleMap = simpleMap;
		this.refOtherPackage = refOtherPackage;
	}


	// Getters and Setters
	public java.util.Map<thrift.pojo.test.pojo.package1.MapKeyPojo, thrift.pojo.test.pojo.package1.MapValuePojo> getRefMap() {
	       return refMap;
	}
	public void setRefMap(java.util.Map<thrift.pojo.test.pojo.package1.MapKeyPojo, thrift.pojo.test.pojo.package1.MapValuePojo> refMap) {
	       this.refMap = refMap;
	}
	public java.util.Map<java.lang.Integer, thrift.pojo.test.pojo.package1.MapValuePojo> getRefValueMap() {
	       return refValueMap;
	}
	public void setRefValueMap(java.util.Map<java.lang.Integer, thrift.pojo.test.pojo.package1.MapValuePojo> refValueMap) {
	       this.refValueMap = refValueMap;
	}
	public java.util.Map<thrift.pojo.test.pojo.package1.MapKeyPojo, java.lang.Integer> getRefKeyMap() {
	       return refKeyMap;
	}
	public void setRefKeyMap(java.util.Map<thrift.pojo.test.pojo.package1.MapKeyPojo, java.lang.Integer> refKeyMap) {
	       this.refKeyMap = refKeyMap;
	}
	public java.util.Map<java.lang.String, java.lang.Integer> getSimpleMap() {
	       return simpleMap;
	}
	public void setSimpleMap(java.util.Map<java.lang.String, java.lang.Integer> simpleMap) {
	       this.simpleMap = simpleMap;
	}
	public java.util.Map<thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo, java.lang.Integer> getRefOtherPackage() {
	       return refOtherPackage;
	}
	public void setRefOtherPackage(java.util.Map<thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo, java.lang.Integer> refOtherPackage) {
	       this.refOtherPackage = refOtherPackage;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestMapStructPojo that = (TestMapStructPojo) o;

        if (refMap != null ? !refMap.equals(that.refMap) : that.refMap != null) return false;
        if (refValueMap != null ? !refValueMap.equals(that.refValueMap) : that.refValueMap != null) return false;
        if (refKeyMap != null ? !refKeyMap.equals(that.refKeyMap) : that.refKeyMap != null) return false;
        if (simpleMap != null ? !simpleMap.equals(that.simpleMap) : that.simpleMap != null) return false;
        if (refOtherPackage != null ? !refOtherPackage.equals(that.refOtherPackage) : that.refOtherPackage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (refMap != null ? (refMap.hashCode() * 31) : 0);

        result = 31 * result + (refValueMap != null ? refValueMap.hashCode() : 0);
        result = 31 * result + (refKeyMap != null ? refKeyMap.hashCode() : 0);
        result = 31 * result + (simpleMap != null ? simpleMap.hashCode() : 0);
        result = 31 * result + (refOtherPackage != null ? refOtherPackage.hashCode() : 0);

        return result;
    }
}