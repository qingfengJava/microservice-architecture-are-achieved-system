package com.gapache.security.entity;

import com.gapache.vertx.redis.annotation.Id;
import com.gapache.vertx.redis.annotation.RedisEntity;
import lombok.Data;

@Data
@RedisEntity("tb_authorize_info")
public class AuthorizeInfoEntity {

    @Id
    private String id;
    private String scopes;
    private String customerInfo;
}
