package com.gapache.user.server.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class AccountRegisterRequest implements Serializable {
    private static final long serialVersionUID = -1011541610302142851L;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 短信验证码
     */
    private String smsCode;
}
