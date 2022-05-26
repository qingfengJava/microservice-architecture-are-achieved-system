package com.gapache.user.common.model;

import com.gapache.commons.model.Error;
import lombok.Getter;

@Getter
public enum UserError implements Error {
    //
    USERNAME_EXISTED(20001, "username existed"),
    USER_NOT_FOUND(20002, "user not found");

    private final Integer code;

    private final String error;

    UserError(Integer code, String error) {
        this.code = code;
        this.error = error;
    }
}
