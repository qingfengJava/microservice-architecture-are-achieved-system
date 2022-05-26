package com.gapache.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SetUserRoleDTO implements Serializable {
    private static final long serialVersionUID = -9199443312819230391L;

    private Long userId;

    private Long roleId;
}
