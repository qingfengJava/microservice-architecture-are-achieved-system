package com.gapache.commons.jvm.bytecode.parse.func;

import com.gapache.commons.jvm.bytecode.parse.attribute.AbstractAttributeInfo;
import com.gapache.commons.jvm.bytecode.parse.ByteCode;

public interface AttributePrinter {

    void printing(ByteCode byteCode, String attributeName, AbstractAttributeInfo attribute);
}
