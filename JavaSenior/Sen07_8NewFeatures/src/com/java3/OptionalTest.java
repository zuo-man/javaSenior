package com.java3;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional<T> 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表这个值存在。或者仅仅保存null
 * ，表示这个值不存在。原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且可以避
 * 免空指针异常。
 *
 * 常用方法：ofNullable(T t)
 *          orElse(T t)
 *
 * @create 2021-11-02 19:19
 */
public class OptionalTest {
    /*
    Optional.of(T t):创建一个Optional 实例，t必须非空
    Optional.emyty():创建一个空的Optional实例
    Option.ofNullable(T t):t可以为null
     */
    @Test
    public void test1(){
        Girl g1 = new Girl();
        g1 = null;
        //of(T t)必须非空
        Optional<Girl> o1 = Optional.of(g1);
    }
    @Test
    public void test2(){
        Girl g2 = new Girl();
        g2 = null;
        //ofNullable(T t):t可以为null
        Optional<Girl> o2 = Optional.ofNullable(g2);
        System.out.println(o2);

        /*
        orElse(T t1):如果当前Optional内部封装的t是非空的，则返回内部的t。
                     如果内部的t是空的，则返回orElse()方法中的参数t1     (不空的话用g2，空的话用g3小优)
         */
        Girl g3 = o2.orElse(new Girl("小优"));
        System.out.println(g3);
    }


    //优化前的getGirlName()
    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }
    @Test
    public void test3(){
        Boy b1 = new Boy();
        String g1 = getGirlName(b1);//获取不到getGirl，空指针
        System.out.println(g1);
    }
    //优化后的getGirlName()
    public String getGirlName1(Boy boy){
        if(boy != null){
            Girl g1 = boy.getGirl();
            if(g1 != null){
                return g1.getName();
            }
        }
        return null;
    }
    @Test
    public void test4(){
        Boy b2 = new Boy();
        String g2 = getGirlName1(b2);
        System.out.println(g2);
    }
    //使用Optional类的getGirlName():
    public String getGirlName2(Boy boy){

        Optional<Boy> b1 = Optional.ofNullable(boy);
        //此时b1一定非空
        Boy b2 = b1.orElse(new Boy(new Girl("无暇")));//orElse方法：若b1非空，则返回b1，若b1空，则返回b2无暇

        Girl g1 = b2.getGirl();

        Optional<Girl> g2 = Optional.ofNullable(g1);
        //此时g2一定非空
        Girl g3 = g2.orElse(new Girl("格兰尼"));

        return g3.getName();
    }
    @Test
    public void test5(){
        Boy b1 = null;//无暇
//        b1 = new Boy();//格兰尼
//        b1 = new Boy(new Girl("唯"));//唯
        String g1 = getGirlName2(b1);
        System.out.println(g1);
    }
}
