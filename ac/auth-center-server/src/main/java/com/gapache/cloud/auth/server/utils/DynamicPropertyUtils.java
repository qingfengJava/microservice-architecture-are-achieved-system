package com.gapache.cloud.auth.server.utils;

import com.netflix.config.DynamicPropertyFactory;


public class DynamicPropertyUtils {

    private final static DynamicPropertyFactory
            DYNAMIC_PROPERTY_FACTORY = DynamicPropertyFactory.getInstance();

    public static String getString(String key) {
        return DYNAMIC_PROPERTY_FACTORY.getStringProperty(key, "").get();
    }
}
