package com.gapache.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = -6310420542695445535L;

    private Long id;

    private String name;

    private String description;
}
