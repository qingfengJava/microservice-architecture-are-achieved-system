package com.gapache.security.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class BasicSignRequest implements Serializable {
    private static final long serialVersionUID = -7159463893062888822L;

    /**
     * 签名值，不参与签名的计算
     */
    private String sign;

    /**
     * ID
     */
    private String clientId;

    /**
     * 当前时间戳，请求5分钟内有效
     */
    private Long timestamp;
}
