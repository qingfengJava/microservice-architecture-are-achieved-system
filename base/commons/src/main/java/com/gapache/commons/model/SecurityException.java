package com.gapache.commons.model;

import lombok.Getter;

@Getter
public class SecurityException extends RuntimeException {
    private static final long serialVersionUID = -3816810995918271563L;

    private final Error error;

    public SecurityException(Error error) {
        super(error.getError());
        this.error = error;
    }
}
