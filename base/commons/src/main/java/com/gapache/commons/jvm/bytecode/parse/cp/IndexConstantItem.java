package com.gapache.commons.jvm.bytecode.parse.cp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndexConstantItem extends ConstantItem {
    private int[] indexes;
}
