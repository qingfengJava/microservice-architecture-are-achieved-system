package com.gapache.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthResourceDTO implements Serializable {
    private static final long serialVersionUID = 5028716674829350085L;

    private Long id;

    private String scope;

    private String name;
}
