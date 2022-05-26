package com.gapache.redis;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableRedis {

    boolean enableTransactionSupport() default false;
}
