package thrift.pojo.test.pojo.package1;

public class TestTypesStructPojo implements java.io.Serializable {
	public enum Fields{
		SimpleString, NonRequiredString, Number16b, Number32b, Number64b, BooleanValue, ByteValue, DoubleValue, EnumType, Ref, ComposedStruct
	};

	private java.lang.String simpleString;
	private java.lang.String nonRequiredString;
	private short number16b;
	private int number32b;
	private long number64b;
	private boolean booleanValue;
	private byte byteValue;
	private double doubleValue;
	private thrift.pojo.test.pojo.package1.EnumStructPojo enumType;
	private thrift.pojo.test.pojo.package1.SimpleStructPojo ref;
	private thrift.pojo.test.pojo.package1.ObjectInnerStructPojo composedStruct;

	public TestTypesStructPojo() {
		super();
	}

	public TestTypesStructPojo(java.lang.String simpleString,java.lang.String nonRequiredString,short number16b,int number32b,long number64b,boolean booleanValue,byte byteValue,double doubleValue,thrift.pojo.test.pojo.package1.EnumStructPojo enumType,thrift.pojo.test.pojo.package1.SimpleStructPojo ref,thrift.pojo.test.pojo.package1.ObjectInnerStructPojo composedStruct) {
		super();

		this.simpleString = simpleString;
		this.nonRequiredString = nonRequiredString;
		this.number16b = number16b;
		this.number32b = number32b;
		this.number64b = number64b;
		this.booleanValue = booleanValue;
		this.byteValue = byteValue;
		this.doubleValue = doubleValue;
		this.enumType = enumType;
		this.ref = ref;
		this.composedStruct = composedStruct;
	}


	// Getters and Setters
	public java.lang.String getSimpleString() {
	       return simpleString;
	}
	public void setSimpleString(java.lang.String simpleString) {
	       this.simpleString = simpleString;
	}
	public java.lang.String getNonRequiredString() {
	       return nonRequiredString;
	}
	public void setNonRequiredString(java.lang.String nonRequiredString) {
	       this.nonRequiredString = nonRequiredString;
	}
	public short getNumber16b() {
	       return number16b;
	}
	public void setNumber16b(short number16b) {
	       this.number16b = number16b;
	}
	public int getNumber32b() {
	       return number32b;
	}
	public void setNumber32b(int number32b) {
	       this.number32b = number32b;
	}
	public long getNumber64b() {
	       return number64b;
	}
	public void setNumber64b(long number64b) {
	       this.number64b = number64b;
	}
	public boolean getBooleanValue() {
	       return booleanValue;
	}
	public void setBooleanValue(boolean booleanValue) {
	       this.booleanValue = booleanValue;
	}
	public byte getByteValue() {
	       return byteValue;
	}
	public void setByteValue(byte byteValue) {
	       this.byteValue = byteValue;
	}
	public double getDoubleValue() {
	       return doubleValue;
	}
	public void setDoubleValue(double doubleValue) {
	       this.doubleValue = doubleValue;
	}
	public thrift.pojo.test.pojo.package1.EnumStructPojo getEnumType() {
	       return enumType;
	}
	public void setEnumType(thrift.pojo.test.pojo.package1.EnumStructPojo enumType) {
	       this.enumType = enumType;
	}
	public thrift.pojo.test.pojo.package1.SimpleStructPojo getRef() {
	       return ref;
	}
	public void setRef(thrift.pojo.test.pojo.package1.SimpleStructPojo ref) {
	       this.ref = ref;
	}
	public thrift.pojo.test.pojo.package1.ObjectInnerStructPojo getComposedStruct() {
	       return composedStruct;
	}
	public void setComposedStruct(thrift.pojo.test.pojo.package1.ObjectInnerStructPojo composedStruct) {
	       this.composedStruct = composedStruct;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestTypesStructPojo that = (TestTypesStructPojo) o;

        if (simpleString != null ? !simpleString.equals(that.simpleString) : that.simpleString != null) return false;
        if (nonRequiredString != null ? !nonRequiredString.equals(that.nonRequiredString) : that.nonRequiredString != null) return false;
        if (number16b != that.number16b) return false;
        if (number32b != that.number32b) return false;
        if (number64b != that.number64b) return false;
        if (booleanValue != that.booleanValue) return false;
        if (byteValue != that.byteValue) return false;
        if (doubleValue != that.doubleValue) return false;
        if (enumType != null ? !enumType.equals(that.enumType) : that.enumType != null) return false;
        if (ref != null ? !ref.equals(that.ref) : that.ref != null) return false;
        if (composedStruct != null ? !composedStruct.equals(that.composedStruct) : that.composedStruct != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (simpleString != null ? (simpleString.hashCode() * 31) : 0);

        result = 31 * result + (nonRequiredString != null ? nonRequiredString.hashCode() : 0);
        result = 31 * result + (int) number16b;
        result = 31 * result + number32b;
        result = 31 * result + (int) (number64b ^ (number64b>>> 32));
        result = 31 * result + (booleanValue ? 1 : 0);
        result = 31 * result + (int) byteValue;
        result = 31 * result + (int) (Double.doubleToLongBits(doubleValue) ^ (Double.doubleToLongBits(doubleValue) >>> 32));
        result = 31 * result + (enumType != null ? enumType.hashCode() : 0);
        result = 31 * result + (ref != null ? ref.hashCode() : 0);
        result = 31 * result + (composedStruct != null ? composedStruct.hashCode() : 0);

        return result;
    }
}