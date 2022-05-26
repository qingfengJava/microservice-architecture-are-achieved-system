package com.gapache.commons.jvm.bytecode.parse.cp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MethodHandleConstantItem extends ConstantItem {
    private int referenceKind;
    private int referenceIndex;
}
