package com.gapache.security.entity;

import com.gapache.vertx.redis.annotation.Id;
import com.gapache.vertx.redis.annotation.RedisEntity;
import lombok.Data;

@Data
@RedisEntity
public class RoleScopesEntity {

    @Id
    private Long roleId;

    private String scopes;
}
