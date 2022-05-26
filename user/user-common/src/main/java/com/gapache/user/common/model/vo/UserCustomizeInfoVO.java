package com.gapache.user.common.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class UserCustomizeInfoVO implements Serializable {
    private static final long serialVersionUID = 2675236376034506830L;

    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private String clientId;

    private String info;
}
