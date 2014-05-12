package thrift.pojo.parameters;

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
        this.setPojoType("java.util.List");

        List<String> genericList = new ArrayList<String>(Arrays.asList(type.substring(14, type.length() - 1).split(",")));
        if (genericList.size() != 1) {
            throw new IllegalArgumentException("Collections must contain two one values");
        }

        listType = new PojoParameter(genericList.get(0), paramName);
        listType.setPojoType(listType.getType());
    }

    @Override
    public void remmapParameters(Map<String, PojoInterface> thirftNameToPojoClassMap) {
        listType.remmapParameters(thirftNameToPojoClassMap);
    }
}
