package com.gapache.web;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE })
public @interface Check {
}
