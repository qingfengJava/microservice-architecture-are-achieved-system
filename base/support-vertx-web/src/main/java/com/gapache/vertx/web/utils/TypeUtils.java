package com.gapache.vertx.web.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeUtils {

    public static Class<?> getActualClass(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypes = parameterizedType.getActualTypeArguments();
            return actualTypes[0].getClass();
        }
        return null;
    }

    public static Type getFutureRawType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypes = parameterizedType.getActualTypeArguments();
            if (actualTypes[0] instanceof ParameterizedType) {
                parameterizedType = (ParameterizedType) actualTypes[0];
                return parameterizedType.getRawType();
            } else {
                return actualTypes[0];
            }
        }
        return type;
    }
}
