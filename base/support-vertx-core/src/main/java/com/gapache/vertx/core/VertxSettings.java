package com.gapache.vertx.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.gapache.vertx.settings")
public class VertxSettings {

    private boolean cluster;

    @Data
    @ConfigurationProperties(prefix = "com.gapache.vertx.web.settings")
    public static class HttpServer {
        private int port = 8080;
    }

    @Data
    @ConfigurationProperties(prefix = "com.gapache.vertx.http.client.settings")
    public static class HttpClient {

    }
}
