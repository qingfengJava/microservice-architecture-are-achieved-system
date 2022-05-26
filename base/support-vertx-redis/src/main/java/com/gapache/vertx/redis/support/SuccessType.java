package com.gapache.vertx.redis.support;

import io.vertx.redis.client.Response;

import java.util.function.Function;

public enum SuccessType {
    //
    SET_OK(res -> "OK".equalsIgnoreCase(res.toString())),
    DEL_OK(res -> "1".equals(res.toString()));

    private final Function<Response, Boolean> success;

    SuccessType(Function<Response, Boolean> success) {
        this.success = success;
    }

    public boolean success(Response response) {
        return success.apply(response);
    }
}
