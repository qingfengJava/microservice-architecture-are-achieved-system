package com.gapache.commons.model;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -8570405796076634812L;

    private final Error error;

    public BusinessException(Error error) {
        super(error.getError());
        this.error = error;
    }
}
