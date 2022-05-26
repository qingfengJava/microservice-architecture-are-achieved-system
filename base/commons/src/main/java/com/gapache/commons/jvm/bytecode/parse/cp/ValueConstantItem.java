package com.gapache.commons.jvm.bytecode.parse.cp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValueConstantItem extends ConstantItem {
    private Object value;
}
