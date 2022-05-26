package com.gapache.elastic.job;

import lombok.Data;

@Data
public class ElasticJobProperties {

    private Zookeeper zookeeper;

    @Data
    public static class Zookeeper {
        private String serverLists;
        private String namespace;
    }
}
