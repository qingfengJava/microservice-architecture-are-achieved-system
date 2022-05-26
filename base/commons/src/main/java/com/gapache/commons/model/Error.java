package com.gapache.commons.model;

public interface Error {

    /**
     * 返回错误码
     *
     * @return 错误码
     */
    Integer getCode();

    /**
     * 返回错误的描述
     *
     * @return 错误的描述
     */
    String getError();
}
