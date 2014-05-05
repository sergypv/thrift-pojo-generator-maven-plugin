package thrift.pojo.test.pojo.package1;

public class MapKeyPojo implements java.io.Serializable {
	public enum Fields{
	Key
	};

		
	private java.lang.String key;

	public MapKeyPojo() {
		super();
	}

	public MapKeyPojo(java.lang.String key) {
		super();

		this.key = key;
	}


	// Getters and Setters
	public java.lang.String getKey() {
	       return key;
	}
	public void setKey(java.lang.String key) {
	       this.key = key;
	}
}