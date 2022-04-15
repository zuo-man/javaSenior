package com.spring5.aopnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强的类
@Component
//Aspect：表示需要增强的类，生成代理对象
@Aspect
//当有多个增强类对同一个方法进行增强，可设置增强类优先级：@Order(数字类型值)， 数字类型值越小优先级越高
@Order(1)
public class UserProxy {

    /**
     * 语法结构： execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表])
     *  * 表示任意权限修饰符都可以                          * 表示当前路径的全部方法名称都执行
     */

    //相同切入点抽取       ，如下全部通知都是对User下的 add 方法进行增强
    @Pointcut(value = "execution(* com.spring5.aopnno.User.add(..))")
    public void point(){}

    //前置通知
    @Before(value = "point()")
    public void before(){
        System.out.println("before...");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "point()")
    public void afterReturning(){
        System.out.println("UserProxy的 后置通知：afterReturning...");
    }

    //最终通知
    @After(value = "point()")
    public void after(){
        System.out.println("最终通知：after...");
    }

    //异常通知
    @AfterThrowing(value = "point()")
    public void afterThrowing(){
        System.out.println("异常通知：afterThrowing...");
    }

    //环绕通知
    @Around(value = "point()")
    public void around(ProceedingJoinPoint pro) throws Throwable{
        System.out.println("环绕之前...");

        //被增强的方法执行
        pro.proceed();

        System.out.println("环绕之后...");
    }
}
