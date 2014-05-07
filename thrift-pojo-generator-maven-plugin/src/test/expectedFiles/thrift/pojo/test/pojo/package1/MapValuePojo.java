package thrift.pojo.test.pojo.package1;

public class MapValuePojo implements java.io.Serializable {
	public enum Fields{
	Value
	};

		
	private int value;

	public MapValuePojo() {
		super();
	}

	public MapValuePojo(int value) {
		super();

		this.value = value;
	}


	// Getters and Setters
	public int getValue() {
	       return value;
	}
	public void setValue(int value) {
	       this.value = value;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapValuePojo that = (MapValuePojo) o;

        if (value != that.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * value;

        return result;
    }
}