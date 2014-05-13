package thrift.pojo.parameters;

import thrift.pojo.ThriftPojoGenerator;
import thrift.pojo.classes.PojoInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PojoParameterList extends PojoParameter{
    public PojoParameter listType;

    public PojoParameterList(String type, String paramName) {
        super(type, paramName);
        setGenericList(true);
        this.setPojoType(ThriftPojoGenerator.POJO_CLASS_LIST);

        String genericType = type.substring(ThriftPojoGenerator.POJO_CLASS_LIST.length() + 1, type.length() -1);
        if (genericType.isEmpty()) {
            throw new IllegalArgumentException("Collections must contain one value");
        }

        listType = new PojoParameter(genericType, paramName);
        listType.setPojoType(listType.getType());
    }

    @Override
    public void remmapParameters(Map<String, PojoInterface> thirftNameToPojoClassMap) {
        listType.remmapParameters(thirftNameToPojoClassMap);
    }
}
