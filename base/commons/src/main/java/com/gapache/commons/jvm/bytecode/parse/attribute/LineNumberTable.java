package com.gapache.commons.jvm.bytecode.parse.attribute;

import lombok.Data;

@Data
public class LineNumberTable {
    private Integer startPc;
    private Integer lineNumber;
}
