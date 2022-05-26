package com.gapache.vertx.web.annotation;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableZeusClients {

    Class<?>[] basePackageClasses() default {};
}
