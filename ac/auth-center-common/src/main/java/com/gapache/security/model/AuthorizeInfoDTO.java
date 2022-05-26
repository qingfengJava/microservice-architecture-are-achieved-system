package com.gapache.security.model;

import lombok.Data;

import java.util.Collection;

@Data
public class AuthorizeInfoDTO {
    private Collection<String> scopes;
    private CustomerInfo customerInfo;
}
