package com.ec.demo.annotation;

import com.ec.demo.enums.CheckTypeEnum;

import java.lang.annotation.*;

//自定义注解
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface ParamCheck {
    //校验类型
    CheckTypeEnum type() default CheckTypeEnum.CHECK_NULL_VALUE;
}
