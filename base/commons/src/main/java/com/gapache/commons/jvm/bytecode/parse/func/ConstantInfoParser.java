package com.gapache.commons.jvm.bytecode.parse.func;

import com.gapache.commons.jvm.bytecode.parse.ByteCode;
import com.gapache.commons.jvm.bytecode.parse.constants.CpTag;

public interface ConstantInfoParser {
    int parsing(CpTag cpTag, int point, String context, ByteCode byteCode);
}
