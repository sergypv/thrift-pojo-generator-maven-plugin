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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapKeyPojo that = (MapKeyPojo) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (key != null ? (key.hashCode() * 31) : 0);

        return result;
    }
}