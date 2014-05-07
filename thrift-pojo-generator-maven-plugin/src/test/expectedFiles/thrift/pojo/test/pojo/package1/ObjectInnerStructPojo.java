package thrift.pojo.test.pojo.package1;

public class ObjectInnerStructPojo implements java.io.Serializable {
	public enum Fields{
		StringVariable, InnerStruct, InnerStructPackage2
	};

		
	private java.lang.String stringVariable;
	private thrift.pojo.test.pojo.package1.SimpleStructPojo innerStruct;
	private thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo innerStructPackage2;

	public ObjectInnerStructPojo() {
		super();
	}

	public ObjectInnerStructPojo(java.lang.String stringVariable,thrift.pojo.test.pojo.package1.SimpleStructPojo innerStruct,thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo innerStructPackage2) {
		super();

		this.stringVariable = stringVariable;
		this.innerStruct = innerStruct;
		this.innerStructPackage2 = innerStructPackage2;
	}


	// Getters and Setters
	public java.lang.String getStringVariable() {
	       return stringVariable;
	}
	public void setStringVariable(java.lang.String stringVariable) {
	       this.stringVariable = stringVariable;
	}
	public thrift.pojo.test.pojo.package1.SimpleStructPojo getInnerStruct() {
	       return innerStruct;
	}
	public void setInnerStruct(thrift.pojo.test.pojo.package1.SimpleStructPojo innerStruct) {
	       this.innerStruct = innerStruct;
	}
	public thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo getInnerStructPackage2() {
	       return innerStructPackage2;
	}
	public void setInnerStructPackage2(thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo innerStructPackage2) {
	       this.innerStructPackage2 = innerStructPackage2;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectInnerStructPojo that = (ObjectInnerStructPojo) o;

        if (stringVariable != null ? !stringVariable.equals(that.stringVariable) : that.stringVariable != null) return false;
        if (innerStruct != null ? !innerStruct.equals(that.innerStruct) : that.innerStruct != null) return false;
        if (innerStructPackage2 != null ? !innerStructPackage2.equals(that.innerStructPackage2) : that.innerStructPackage2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (stringVariable != null ? (stringVariable.hashCode() * 31) : 0);

        result = 31 * result + (innerStruct != null ? innerStruct.hashCode() : 0);
        result = 31 * result + (innerStructPackage2 != null ? innerStructPackage2.hashCode() : 0);

        return result;
    }
}