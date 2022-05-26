package com.gapache.redis;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableRedisLua {

    Class<? extends LuaScript>[] value() default {};
}
