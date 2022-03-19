package com.exer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @create 2021-10-30 11:03
 */
@Retention(RetentionPolicy.RUNTIME)//指明所修饰的Annotation的生命周期
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})//用于指定被修饰的Annotation能用于修饰哪些程序元素

public @interface MyAnnotation {
    String value() default "hello";//default：指定默认值


}
