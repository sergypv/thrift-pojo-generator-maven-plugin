package org.disges.thrift.plugin.parameters;

import org.disges.thrift.plugin.ThriftPojoGenerator;

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
