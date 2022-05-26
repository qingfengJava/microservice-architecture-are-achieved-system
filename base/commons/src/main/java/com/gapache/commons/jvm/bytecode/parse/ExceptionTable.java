package com.gapache.commons.jvm.bytecode.parse;

import lombok.Data;

@Data
public class ExceptionTable {
    private Integer startPc;
    private Integer endPc;
    private Integer handlerPc;
    private Integer catchType;
}
