package com.gapache.cloud.auth.server.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserClientRelationDTO implements Serializable {
    private static final long serialVersionUID = 2014421490617833548L;

    private Long id;

    private Long userId;

    private Long clientId;
}
