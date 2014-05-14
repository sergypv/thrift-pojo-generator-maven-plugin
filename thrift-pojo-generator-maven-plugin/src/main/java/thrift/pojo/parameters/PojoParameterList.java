package thrift.pojo.parameters;

import thrift.pojo.ThriftPojoGenerator;
import thrift.pojo.classes.PojoInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PojoParameterList extends PojoParameterCollectionAbstract{
    public PojoParameterList(String type, String paramName) {
        super(type, paramName);
        setGenericList(true);
    }

    @Override
    protected String getCollectionClassName() {
        return ThriftPojoGenerator.POJO_CLASS_LIST;
    }
}
