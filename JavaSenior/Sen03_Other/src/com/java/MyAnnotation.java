package com.java;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/**
 * 自定义注解
 *
 * ①参照@SuppressWarnings定义
 * ②注解声明为：@interface
 * ③内部定义成员，通常使用Value表示
 * ④可以指定成员的默认值，使用default定义
 * ⑤如果自定义注解没有成员，表明是一个表示作用
 *
 * 如果注解有成员，在使用注解时，需要指明成员的值
 * 自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 * 自定义注解通常都会指明两个元注解：Retention、Target
 *
 * @create 2021-10-17 15:52
 */

@Retention(RetentionPolicy.RUNTIME)//指明所修饰的Annotation的生命周期
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})//用于指定被修饰的Annotation能用于修饰哪些程序元素

@Repeatable(MyAnnotation2.class)//可重复注解                                                                 //TYPE修饰类，comstructor修饰构造器....。
public @interface MyAnnotation {

    String value() default "hello";//default：指定默认值

//    String[] value();//多个属性时

}
