package com.gapache.commons.model;

public enum  CommonError implements Error {
    //
    PARAM_ERROR(999998, "参数错误");

    private final int code;
    private final String error;

    CommonError(int code, String error) {
        this.code = code;
        this.error = error;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getError() {
        return error;
    }
}
