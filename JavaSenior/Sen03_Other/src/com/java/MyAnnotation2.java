package com.java;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @create 2021-10-17 16:40
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
public @interface MyAnnotation2 {
    MyAnnotation[] value();
}
