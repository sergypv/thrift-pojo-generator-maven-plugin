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
}