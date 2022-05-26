package com.gapache.security.annotation;

import java.lang.annotation.*;


@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NeedAuth {
    /**
     * 分类名称
     *
     * @return 分类名称
     */
    String value();
}
