package com.gapache.commons.jvm.bytecode.parse;

import lombok.Data;

/**
 * @author ZhaoZezhong
 * create on 2020/3/28 00:04
 */
@Data
public class ExceptionTable {
    private Integer startPc;
    private Integer endPc;
    private Integer handlerPc;
    private Integer catchType;
}
