package com.gapache.commons.model;

import lombok.Getter;

@Getter
public enum GlobalResponse implements BaseResponse {
    /**
     * 处理成功
     */
    SUCCESS(220000, "处理成功"),

    /**
     * 处理失败
     */
    FAILED(220000, "处理失败"),

    /**
     * 无效的TOKEN
     */
    INVALID_TOKEN(220000, "无效的TOKEN"),

    /**
     * 无效的参数
     */
    INVALID_PARAM(220000, "无效的参数"),

    /**
     * 服务器错误
     */
    ERROR(229999, "服务器错误");

    GlobalResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 响应代码
     */
    private final int code;

    /**
     * 响应消息
     */
    private final String message;
}
