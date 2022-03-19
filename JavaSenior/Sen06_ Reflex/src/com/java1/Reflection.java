package com.java1;

import com.exer.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @create 2021-10-30 13:21
 */
public class Reflection {
    //操作运行时类中的指定方法
    @Test
    public void testMethod() throws Exception {
        Class c = Person.class;

        //创建运行时类的对象
        Person p = (Person)c.newInstance();//object类型强转成Person类型

        /*
        1.获取指定的某个方法
        getDeclaredMethoud():参数1：指明获取的方法的名称   参数2：指明获取的方法的形参列表
         */
        Method show = c.getDeclaredMethod("show", String.class);

        //2.保证当前方法是可访问的
        show.setAccessible(true);

        /*
        3.调用方法的invoke():参数1：方法的调用者    参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用方法的返回值
         */
        Object o = show.invoke(p,"China");//String nation = p.show()
        System.out.println(o);


        System.out.println("****调用静态方法****");
        //private static void walk

        Method walk = c.getDeclaredMethod("walk");
        walk.setAccessible(true);
        //如果调用的运行时类的方法没有返回值，则此invoke()返回null
        Object o1 = walk.invoke(Person.class);//wals.invoke(null)也行
        System.out.println(o1);//null
    }

    //操作运行时类的指定属性
    @Test
    public void testFiled() throws Exception{
        Class c = Person.class;

        //创建运行类的对象
        Person p = (Person)c.newInstance();//object类型强转成Person类型

        //1.getDeclaredField(Sting fielName):获取运行时类中指定变量名的属性
        Field name = c.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);
        /*
        设置当前属性的值
        set():参数1：指明设置哪个对象的属性   参数2：将此属性值设置为多少
         */
        name.set(p,"奈乐");

        /*
        获取当前属性的值
        get():参数1(p)：获取哪个对象的当前属性值
         */
        System.out.println(name.get(p));
    }
    @Test//通常不采用此方式
    public void testField1() throws Exception {
        Class c = Person.class;

        //创建运行类的对象
        Person p = (Person)c.newInstance();//object类型强转成Person类型

        /*获取指定的属性：要求运行时类中属性声明为public*/
        Field id = c.getField("id");

        id.set(p,1001);

        System.out.println(id.get(p));
    }


    //调用运行时类的指定构造器
    @Test
    public void testConstructor() throws Exception {
        Class c = Person.class;

        //private Person(String name)
        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表
         */
        Constructor con = c.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        con.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person per = (Person) con.newInstance("朱诺");
        System.out.println(per);
    }
}
