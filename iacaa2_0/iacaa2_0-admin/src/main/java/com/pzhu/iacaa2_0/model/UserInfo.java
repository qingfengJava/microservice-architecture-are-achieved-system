package com.pzhu.iacaa2_0.model;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private String name;
    private String introduction;
    private List<String> roles;
    private String avatar;
    private String token;
}
