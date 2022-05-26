package com.gapache.vertx.web.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface VertxController {
}
