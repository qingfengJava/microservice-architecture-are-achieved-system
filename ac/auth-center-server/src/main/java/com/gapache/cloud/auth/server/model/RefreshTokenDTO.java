package com.gapache.cloud.auth.server.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RefreshTokenDTO implements Serializable {
    private static final long serialVersionUID = 4970429787063539266L;

    private Long userId;

    private String accessToken;
}
