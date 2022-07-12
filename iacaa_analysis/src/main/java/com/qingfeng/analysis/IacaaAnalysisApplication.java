package com.qingfeng.analysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 清风学Java
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.qingfeng.analysis.dao")
public class IacaaAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(IacaaAnalysisApplication.class, args);
    }

}
