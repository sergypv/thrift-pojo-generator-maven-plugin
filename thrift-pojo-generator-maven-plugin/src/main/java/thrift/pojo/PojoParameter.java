package thrift.pojo;

public class PojoParameter {
	public String type;
	public String pojoType = null;
	public boolean isPojo = false;
	public boolean isEnumPojo = false;
	public String nameLowerCase;
	public String nameUpperCase;

	public PojoParameter(String type, String paramName) {
		this.type = type;
		this.nameLowerCase = paramName.substring(0, 1).toLowerCase() + paramName.substring(1);
		this.nameUpperCase = paramName.substring(0, 1).toUpperCase() + paramName.substring(1);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNameLowerCase() {
		return nameLowerCase;
	}

	public void setNameLowerCase(String nameLowerCase) {
		this.nameLowerCase = nameLowerCase;
	}

	public String getNameUpperCase() {
		return nameUpperCase;
	}

	public void setNameUpperCase(String nameUpperCase) {
		this.nameUpperCase = nameUpperCase;
	}

	public boolean isPojo() {
		return isPojo;
	}

	public void setPojo(boolean isPojo) {
		this.isPojo = isPojo;
	}

	public String getPojoType() {
		return pojoType;
	}

	public void setPojoType(String pojoType) {
		this.pojoType = pojoType;
	}

	@Override
	public String toString() {
		return "PojoParameter [type=" + type + ", name=" + nameLowerCase + "]";
	}

	public boolean isEnumPojo() {
		return isEnumPojo;
	}

	public void setEnumPojo(boolean isEnumPojo) {
		this.isEnumPojo = isEnumPojo;
	}
}
