package com.gapache.vertx.core;

public interface LifeCycle {

    /**
     * 启动之前
     */
    void beforeStart(String name);

    /**
     * 启动
     */
    void starting();

    /**
     * 启动后
     */
    void afterStarting();

    /**
     * 销毁之前
     */
    void beforeDestroy();

    /**
     * 销毁
     */
    void destroy();
}
