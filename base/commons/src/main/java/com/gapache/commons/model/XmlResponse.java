package com.gapache.commons.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class XmlResponse implements Serializable {
    private static final long serialVersionUID = 4844312337965571784L;

    /**
     * 响应头
     */
    protected ResponseHead head;

    /**
     * 响应身体Resp信息
     */
    private RespInfo respInfo;
}
