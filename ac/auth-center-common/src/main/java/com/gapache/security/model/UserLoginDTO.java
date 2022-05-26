package com.gapache.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginDTO implements Serializable {
    private static final long serialVersionUID = -7087634406785297834L;

    private String username;
    private String password;
    private String clientId;
}
