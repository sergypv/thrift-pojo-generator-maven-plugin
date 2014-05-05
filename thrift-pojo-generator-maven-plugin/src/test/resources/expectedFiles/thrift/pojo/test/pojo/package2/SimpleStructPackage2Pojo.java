package thrift.pojo.test.pojo.package2;

public class SimpleStructPackage2Pojo implements java.io.Serializable {
	public enum Fields{
	Name
	};

		
	private java.lang.String name;

	public SimpleStructPackage2Pojo() {
		super();
	}

	public SimpleStructPackage2Pojo(java.lang.String name) {
		super();

		this.name = name;
	}


	// Getters and Setters
	public java.lang.String getName() {
	       return name;
	}
	public void setName(java.lang.String name) {
	       this.name = name;
	}
}