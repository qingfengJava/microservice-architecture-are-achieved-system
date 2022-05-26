package com.gapache.commons.model;

import java.util.Map;

public class ParamException extends RuntimeException {
    private static final long serialVersionUID = -878270520763922880L;

    private final Map<String, StringBuilder> errors;

    public ParamException(Map<String, StringBuilder> errors) {
        super("参数错误", null, false, false);
        this.errors = errors;
    }

    public Map<String, StringBuilder> getErrors() {
        return errors;
    }
}
