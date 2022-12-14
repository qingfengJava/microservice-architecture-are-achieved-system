package com.gapache.vertx.web.annotation;

import java.lang.annotation.*;

/**
 * @author ZhaoZezhong
 * @since 2021/3/2 9:35 上午
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DeleteRouting {

    String value() default "";
}
