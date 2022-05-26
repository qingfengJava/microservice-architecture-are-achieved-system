package com.gapache.cloud.auth.server.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAuthorizeDTO implements Serializable {
    private static final long serialVersionUID = -3291230032181953188L;

    private String scopes;

    private String redirectUrl;
}
