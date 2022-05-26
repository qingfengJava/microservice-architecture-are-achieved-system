package com.gapache.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PositionDTO implements Serializable {
    private static final long serialVersionUID = -3758893741500880279L;

    private Long id;

    private String name;

    private Long aboveId;

    private Long companyId;
}
