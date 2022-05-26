package com.gapache.user.sdk.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableUserServerFeign {
}
