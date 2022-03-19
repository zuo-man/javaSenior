package com.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @create 2021-10-27 17:26
 */
public class ReflectionTest {
    //反射之前，对于person操作
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person P1 = new Person("格兰尼",22);

        //2.通过对象，调用其内部类的属性，方法
        P1.age = 19;//修改
        System.out.println(P1.toString());

        //在Person类的内部，不可通过Person类的对象调用私有结构：  name、showNation()、私有构造器
        P1.show();
    }
    //反射之后，对于Person操作
    @Test
    public void test2() throws Exception {
        Class C1 = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = C1.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("无暇",18);
        Person p = (Person)obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性、方法
        Field age = C1.getDeclaredField("age");
        age.set(p,20);
        System.out.println(p.toString());
        //调用方法
        Method show = C1.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("************");

        //调用反射，可以调用Person类的私有结构。比如：私有构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = C1.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person)cons1.newInstance("小真");//强转
        System.out.println(p1);

        //调用私有的属性
        Field name = C1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"格兰尼");//将p1的小真改成格兰尼
        System.out.println(p1);

        //调用私有方法
        Method showNation = C1.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String)showNation.invoke(p1,"中国");//相当于String nation = P1.showNation("中国")
        System.out.println(nation);
    }
    /*
    1.类的加载过程
    程序经过javac.exe命令之后，会生成一个或多个字节码文件（.class结尾）
    接着使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
    此过程就称为类的加载。加载到内存中的类，就称为运行时类，此运行时类，就作为Class的一个实例

    2.换句话说，Class的实例就对应着一个运行时类
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，可以通过不同的方式获取此运行时类
     */
    //获取Class的实例方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class c1 = Person.class;
        System.out.println(c1);
        //方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class c2 = p1.getClass();
        System.out.println(c2);

        //方式三：调用Class的静态方法:forName(String classPath)
        Class c3 = Class.forName("com.java.Person");
        System.out.println(c3);

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);




        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class c4 = classLoader.loadClass("com.java.Person");
        System.out.println(c4);

        System.out.println(c1 == c4);
    }
}
