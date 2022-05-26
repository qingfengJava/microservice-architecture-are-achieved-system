package com.gapache.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyDTO implements Serializable {
    private static final long serialVersionUID = 9153313079860484809L;

    private Long id;

    private String name;

    private Long aboveId;

    private String clientId;
}
