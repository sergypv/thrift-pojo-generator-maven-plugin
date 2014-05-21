package org.disges.thrift.plugin.parameters;

import org.disges.thrift.plugin.classes.PojoInterface;

import java.util.Map;

public abstract class PojoParameterCollectionAbstract extends PojoParameter{
    public PojoParameter listType;

    public PojoParameterCollectionAbstract(String type, String paramName) {
        super(type, paramName);
        this.setPojoType(getCollectionClassName());

        String genericType = type.substring(getCollectionClassName().length() + 1, type.length() -1);
        if (genericType.isEmpty()) {
            throw new IllegalArgumentException("Collections must contain one generic value");
        }

        listType = new PojoParameter(genericType, paramName);
        listType.setPojoType(listType.getType());
    }

    @Override
    public void remmapParameters(Map<String, PojoInterface> thirftNameToPojoClassMap) {
        listType.remmapParameters(thirftNameToPojoClassMap);
    }

    protected abstract String getCollectionClassName();
}
