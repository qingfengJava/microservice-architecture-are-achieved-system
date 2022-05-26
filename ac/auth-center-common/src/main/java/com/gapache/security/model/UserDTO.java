package com.gapache.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -9011990092228036046L;

    private String username;

    private String password;

    private Long roleId;
}
