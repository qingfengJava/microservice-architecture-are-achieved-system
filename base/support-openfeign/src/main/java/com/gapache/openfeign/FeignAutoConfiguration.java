package com.gapache.openfeign;

import com.gapache.commons.helper.AccessCardHeaderHolder;
import com.gapache.commons.model.AuthConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

//import com.gapache.sentinel.ProtectingCaller;

@Configuration
public class FeignAutoConfiguration implements RequestInterceptor {

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String header = AccessCardHeaderHolder.getHeader();
        if (StringUtils.isNotBlank(header)) {
            requestTemplate.header(AuthConstants.ACCESS_CARD_HEADER, header);
        }
        requestTemplate.header(AuthConstants.X_FROM_HEADER, applicationName);
    }

//    @Bean
//    @ConditionalOnMissingBean
//    public ProtectingCaller protectingCaller() {
//        return new FeignProtectingCaller();
//    }
}
