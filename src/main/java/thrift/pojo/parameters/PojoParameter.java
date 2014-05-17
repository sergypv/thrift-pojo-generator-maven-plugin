package thrift.pojo.parameters;

import thrift.pojo.classes.PojoEnum;
import thrift.pojo.classes.PojoInterface;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PojoParameter {

    public static final String SHORT = "short";
    public static final String INT = "int";
    public static final String LONG = "long";
    public static final String BOOLEAN = "boolean";
    public static final String BYTE = "byte";
    public static final String DOUBLE = "double";
    private static final Set<String> PRIMITIVE_TYPES = new HashSet<String>();

    static {
        PRIMITIVE_TYPES.add(SHORT);
        PRIMITIVE_TYPES.add(INT);
        PRIMITIVE_TYPES.add(LONG);
        PRIMITIVE_TYPES.add(BOOLEAN);
        PRIMITIVE_TYPES.add(BYTE);
        PRIMITIVE_TYPES.add(DOUBLE);
    }

	public String type;
	public String pojoType = null;
	public boolean isPojo = false;
	public boolean isEnumPojo = false;
	public boolean isGenericMap = false;
    public boolean isGenericList = false;
    public boolean isGenericSet = false;
    public boolean isPrimitive;
    public String nameLowerCase;
    public String nameUpperCase;
    public String hashCodeCommand = null;

	public PojoParameter(String type, String paramName) {
		this.type = type;
		this.nameLowerCase = paramName.substring(0, 1).toLowerCase() + paramName.substring(1);
		this.nameUpperCase = paramName.substring(0, 1).toUpperCase() + paramName.substring(1);
        this.isPrimitive = PRIMITIVE_TYPES.contains(type);
        if (this.isPrimitive) {
            initializePrimitiveParam();
        }
    }

    private void initializePrimitiveParam(){
        if (type.equals(SHORT) || type.equals(BYTE)) {
            this.hashCodeCommand = "(int) " + this.nameLowerCase;
        } else if (type.equals(INT)) {
            this.hashCodeCommand = this.nameLowerCase;
        } else if (type.equals(LONG)) {
            this.hashCodeCommand = "(int) (" + this.nameLowerCase + " ^ (" + this.nameLowerCase + ">>> 32))";
        } else if (type.equals(BOOLEAN)) {
            this.hashCodeCommand = "(" +  this.nameLowerCase + " ? 1 : 0)";
        } else if (type.equals(DOUBLE)) {
            this.hashCodeCommand = "(int) (Double.doubleToLongBits(" +  this.nameLowerCase + ") ^ (Double.doubleToLongBits(" +  this.nameLowerCase + ") >>> 32))";
        }
    }

	public void remmapParameters(Map<String, PojoInterface> thirftNameToPojoClassMap) {
		PojoInterface pojo = thirftNameToPojoClassMap.get(getType());
		if (pojo != null) {
			setPojoType(pojo.getClassPackage() + "." + pojo.getClassName());
			if (pojo instanceof PojoEnum) {
				setEnumPojo(true);
			} else {
				setPojo(true);
			}
		}
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

	protected boolean isGenericMap() {
		return isGenericMap;
	}

	protected void setGenericMap(boolean isGenericMap) {
		this.isGenericMap = isGenericMap;
	}

    public boolean isPrimitive() {
        return isPrimitive;
    }

    public String getHashCodeCommand() {
        return hashCodeCommand;
    }

    public boolean isGenericList() {
        return isGenericList;
    }

    public void setGenericList(boolean isGenericList) {
        this.isGenericList = isGenericList;
    }

    public boolean isGenericSet() {
        return isGenericSet;
    }

    public void setGenericSet(boolean isGenericSet) {
        this.isGenericSet = isGenericSet;
    }
}
