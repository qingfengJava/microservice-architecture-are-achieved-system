package com.gapache.commons.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IPageRequest<T> implements Serializable {
    private static final long serialVersionUID = 1377278131499735210L;

    private Integer page = 1;
    private Integer number = 10;
    private String sort;
    private Boolean asc = false;

    private T customParams;
}
