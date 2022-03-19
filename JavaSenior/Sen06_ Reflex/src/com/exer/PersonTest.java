package com.exer;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @create 2021-10-30 11:14
 */
public class PersonTest {
    //获取运行时类的属性结构
    @Test
    public void FileTest(){
        Class c1 = Person.class;

        //getFileds():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fie = c1.getFields();
        for(Field f : fie){
            System.out.println(f);
        }
        System.out.println();

        //getDeclaredFileds():获取当前运行时类中声明的所有属性(不包含父类中声明的属性)
        Field[] defie = c1.getDeclaredFields();
        for(Field f : defie){
            System.out.println(f);
        }
    }
    //获取运行时类的方法结构
    @Test
    public void MethodTest(){
        Class c1 = Person.class;

        //getMethods():获取当前运行时类及其父类中声明为public访问权限的方法
        Method[] me = c1.getMethods();
        for(Method m : me){
            System.out.println(m);
        }
        System.out.println();

        //getDeclaredMethods():获取当前运行时类中声明的所有方法(不包含父类中声明的方法)
        Method[] deme = c1.getDeclaredMethods();
        for(Method m : deme){
            System.out.println(m);
        }
    }
    //获取运行时类的方法结构
    @Test
    public void ConstructorsTest(){
        Class c1 = Person.class;

        //getConstructors():获取当前运行时类及其父类中声明为public访问权限的构造器
        Constructor[] con = c1.getConstructors();
        for(Constructor c : con){
            System.out.println(con);
        }
        System.out.println();

        //getDeclaredConstructors():获取当前运行时类中声明的所有构造器(不包含父类中声明的构造器)
        Constructor[] decon = c1.getDeclaredConstructors();
        for(Constructor c : decon){
            System.out.println(decon);
        }
    }
    //获取运行类的父类
    @Test
    public void test2(){
        Class c1 = Person.class;

        Class superclass = c1.getSuperclass();
        System.out.println(superclass);


        //获取运行时类带泛型的父类
        Type gen = c1.getGenericSuperclass();
        System.out.println(gen);
    }

    //获取运行时类的带泛型的父类的泛型
    @Test
    public void test3(){
        Class clazz=Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType =(ParameterizedType)genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments =paramType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }
    //获取运行时类实现的接口
    @Test
    public void test4(){
        Class c1= Person.class;

        Class[] interfaces = c1.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();

        //获取运行时类父类实现的接口
        Class[] interfaces1 = c1.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
    }
    //获取运行时类所在的包
    @Test
    public void test5(){
        Class c1 = Person.class;

        Package pack = c1.getPackage();
        System.out.println(pack);
    }
    //获取运行时类声明的注解
    @Test
    public void test6(){
        Class c1 = Person.class;

        Annotation[] ann = c1.getAnnotations();
        for(Annotation a : ann){
            System.out.println(a);
        }
    }
}


