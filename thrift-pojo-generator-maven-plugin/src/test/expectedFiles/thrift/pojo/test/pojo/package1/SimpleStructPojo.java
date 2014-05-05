package thrift.pojo.test.pojo.package1;

public class SimpleStructPojo implements java.io.Serializable {
	public enum Fields{
	Name
	};

		
	private java.lang.String name;

	public SimpleStructPojo() {
		super();
	}

	public SimpleStructPojo(java.lang.String name) {
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