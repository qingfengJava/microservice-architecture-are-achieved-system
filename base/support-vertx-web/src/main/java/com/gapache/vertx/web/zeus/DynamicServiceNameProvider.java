package com.gapache.vertx.web.zeus;

public interface DynamicServiceNameProvider {

    /**
     * 获取ServiceName
     *
     * @return ServiceName
     */
    String getServiceName();

    /**
     * ip
     *
     * @return 指定Ip
     */
    default String ip() {
        return null;
    }

    /**
     * port
     *
     * @return 指定端口
     */
    default int port() {
        return 0;
    }
}
