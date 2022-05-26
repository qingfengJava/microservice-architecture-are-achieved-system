package com.gapache.commons.jvm.bytecode.parse.cp;

import com.gapache.commons.jvm.bytecode.parse.constants.CpTag;
import lombok.Data;

@Data
public class ConstantItem {
    private CpTag tag;
    private String description;

    public Object checkValue() {
        if (this instanceof ValueConstantItem) {
            return ((ValueConstantItem) this).getValue();
        }
        return null;
    }
}
