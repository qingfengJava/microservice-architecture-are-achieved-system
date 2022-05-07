package com.gapache.security.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 清风学Java
 * @since 2020/8/6 5:13 下午
 */
@Data
public class AuthResourceDTO implements Serializable {
    private static final long serialVersionUID = 5028716674829350085L;

    private Long id;

    private String scope;

    private String name;
}
