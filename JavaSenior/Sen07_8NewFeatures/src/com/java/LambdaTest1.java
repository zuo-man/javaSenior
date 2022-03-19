package com.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
/**
 * Lambda表达式的使用
 *
 * 1.举例： (o1,o2) -> Integer.compare(o1,o2);
 * 2.格式：
 *      ->:Lambda操作符  或  箭头操作符
 *      ->左边：Lambda形参列表（就是接口中的抽象方法的形参列表）
 *      ->右边：Lambda体 （就是重写的抽象方法的方法体）
 *
 * 3.Lambda表达式的使用（6种情况）
 *      总结：
 *      ->左边：形参类别参数类型（类型推断）省略，只有一个参数，()省略
 *      ->右边：只有一条执行语句（可能是ruturn语句），{}省略
 *
 * 4:Lambda表达式的本质：作为函数式接口的实例
 *
 * 5.接口中，只声明了一个抽象方法，则此接口就称为函数式接口，使用注解检查是否是一个函数式接口
 *
 * 匿名实现类表示的现在都可以用Lambda表达式写
 *
 * @create 2021-10-31 10:43
 */
public class LambdaTest1 {
    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("吃饭");
            }
        };
        r1.run();


        Runnable r2 = () -> {System.out.println("干饭");};
        r2.run();
    }
    //语法格式二：Lambda需要一个参数，但没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("1");


        Consumer<String> con1 = (String s) -> System.out.println(s);
        con1.accept("2");
    }
    //语法格式三：数据类型可以省略，可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("1");

                              //String省略
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("2");
    }
    //语法格式四：Lambda若只需要一个参数，参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String> con = (s) -> System.out.println(s);
        con.accept("1");

        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("2");
    }
    //语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com.compare(1,2));


        Comparator<Integer> com1 = (o1,o2) -> {System.out.println(o1);
                                               System.out.println(o2);
                                               return o1.compareTo(o2);};
        System.out.println(com1.compare(2,1));
    }
    //语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com = (o1,o2) -> {return o1.compareTo(o2);};
        System.out.println(com.compare(1,2));


        Comparator<Integer> com1 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com1.compare(2,1));
    }
}
