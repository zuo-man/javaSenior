package com.spring5.aopnno;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//当有多个增强类对同一个方法进行增强，可设置增强类优先级：@Order(数字类型值)， 数字类型值越小优先级越高
@Order(2)
public class PersonProxy {

    //后置通知（返回通知）    ，对User下的add方法进行增强
    @AfterReturning(value = "execution(* com.spring5.aopnno.User.add(..))")
    public void afterReturning(){
        System.out.println("PersonProxy的 后置通知：afterReturning...");
    }
}
