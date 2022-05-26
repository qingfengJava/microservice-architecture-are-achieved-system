package com.gapache.commons.jvm.bytecode.parse.attribute;

import lombok.Data;

import java.util.List;

@Data
public class BootstrapMethod {
    private Integer bootstrapMethodRef;
    private Integer numBootstrapArguments;
    private List<String> bootstrapArguments;
}
