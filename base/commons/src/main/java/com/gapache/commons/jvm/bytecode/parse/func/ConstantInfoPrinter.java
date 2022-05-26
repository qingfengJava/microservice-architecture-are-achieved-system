package com.gapache.commons.jvm.bytecode.parse.func;

import com.gapache.commons.jvm.bytecode.parse.cp.ConstantItem;

import java.util.Map;

@FunctionalInterface
public interface ConstantInfoPrinter {
    void print(Map<Integer, ConstantItem> constantPool, int index, ConstantItem item);
}
