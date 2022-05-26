package com.gapache.commons.proxy.lazy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyBean {
    private String key;
    private Object value;

    @Override
    public String toString() {
        return "PropertyBean{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}' + getClass();
    }
}
