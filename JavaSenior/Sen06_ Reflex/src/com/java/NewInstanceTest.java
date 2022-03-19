package com.java;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @create 2021-10-29 21:26
 */
public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class<Person> c1 = Person.class;

        /*
        newInstance()：调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参构造器

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够。通常，设置为public

        在javabean中要求提供一个public的空参构造器，原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        Person p1 = c1.newInstance();
        System.out.println(p1);
    }

    //反射的动态性
    @Test
    public void test2(){
        int num = new Random().nextInt(3);//输出0或1或2
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";//java.sql.Date没有空参构造器，调用时异常
                break;
            case 2:
                classPath = "com.java.Person";
                break;
        }
        try {
            Object o = getInstance(classPath);
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    创建一个指定类的对象
    classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception{
        Class c1 = Class.forName(classPath);
        return c1.newInstance();
    }
}
