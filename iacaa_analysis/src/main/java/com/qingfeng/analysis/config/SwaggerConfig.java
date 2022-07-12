package com.qingfeng.analysis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/7/13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDocket(){

        //创建封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《毕业要求达成评价及分析系统》评价模块后端接口说明")
                .description("此文档详细说明了《毕业要求达成评价及分析系统》评价模块后端接口规范....")
                .version("v 2.0.1")
                .contact( new Contact("清风学Java","www.qingfeng.com","qingfeng@Java.com") );
        ApiInfo apiInfo =  apiInfoBuilder.build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo) //指定生成的文档中的封面信息：文档标题、版本、作者
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qingfeng.analysis.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

}
