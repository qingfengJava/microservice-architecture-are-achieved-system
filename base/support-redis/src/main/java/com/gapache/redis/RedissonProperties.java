package com.gapache.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.gapache.redisson")
public class RedissonProperties {
    private String address;
    private Integer database;
    private String password;
}
