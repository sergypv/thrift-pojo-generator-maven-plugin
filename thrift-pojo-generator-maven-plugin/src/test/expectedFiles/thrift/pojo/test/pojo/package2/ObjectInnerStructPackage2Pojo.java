package thrift.pojo.test.pojo.package2;

public class ObjectInnerStructPackage2Pojo implements java.io.Serializable {
	public enum Fields{
		StringVariable, InnerStruct
	};

		
	private java.lang.String stringVariable;
	private thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo innerStruct;

	public ObjectInnerStructPackage2Pojo() {
		super();
	}

	public ObjectInnerStructPackage2Pojo(java.lang.String stringVariable,thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo innerStruct) {
		super();

		this.stringVariable = stringVariable;
		this.innerStruct = innerStruct;
	}


	// Getters and Setters
	public java.lang.String getStringVariable() {
	       return stringVariable;
	}
	public void setStringVariable(java.lang.String stringVariable) {
	       this.stringVariable = stringVariable;
	}
	public thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo getInnerStruct() {
	       return innerStruct;
	}
	public void setInnerStruct(thrift.pojo.test.pojo.package2.SimpleStructPackage2Pojo innerStruct) {
	       this.innerStruct = innerStruct;
	}
}