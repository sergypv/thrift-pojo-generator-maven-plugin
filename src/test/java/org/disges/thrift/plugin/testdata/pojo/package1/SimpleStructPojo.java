package org.disges.thrift.plugin.testdata.pojo.package1;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleStructPojo that = (SimpleStructPojo) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (name != null ? (name.hashCode() * 31) : 0);

        return result;
    }
}