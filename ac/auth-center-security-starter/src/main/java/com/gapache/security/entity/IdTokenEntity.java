package com.gapache.security.entity;

import com.gapache.vertx.redis.annotation.Id;
import com.gapache.vertx.redis.annotation.RedisEntity;
import lombok.Data;

@Data
@RedisEntity("tb_id_token")
public class IdTokenEntity {

    @Id
    private Long userId;

    private String token;
}
