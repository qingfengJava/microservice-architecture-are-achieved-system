package com.gapache.commons.jvm.bytecode.parse;

import com.gapache.commons.jvm.bytecode.parse.attribute.AbstractAttributeInfo;
import com.gapache.commons.jvm.bytecode.parse.constants.AccessFlag;
import lombok.Data;

import java.util.List;

@Data
public class MethodInfo {
    private List<AccessFlag> accessFlags;
    private Integer nameIndex;
    private Integer descriptorIndex;
    private Integer attributesCount;
    private List<AbstractAttributeInfo> attributes;
}
