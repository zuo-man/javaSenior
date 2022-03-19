package com.java;

/**
 * @create 2021-11-04 20:13
 */
public interface MyInterface {
    //如下的三个默认方法权限修饰符都是public
    void methdoAbstract();

    static void methodStatic(){
        System.out.println("静态方法");
    }
    default void methodDefault(){
        System.out.println("默认方法");
    }

    //java9中允许接口中定义 私有 方法
    private void methodPrivate(){
        System.out.println("静态方法");
    }
}
