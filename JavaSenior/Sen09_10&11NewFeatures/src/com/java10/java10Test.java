package com.java10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-11-05 12:59
 */
public class java10Test {
    /*
    var局部变量类型推断:根据右边变量值的类型推断左边变量类型
     */
    @Test
    public void test1(){
        //1.声明变量时，根据所附的值，推断变量的类型
        var num = 1;

        //之前
        ArrayList<String> A1 = new ArrayList<>();
        //java10
        var A2 = new ArrayList<String>();//<>中可以声明泛型，否则默认是Object类型
        A2.add("小优");

        //2.遍历操作
        //之前
        for(String i : A2){
        }
        //之后
        for(var i : A2){
            System.out.println(i);
            System.out.println(i.getClass());
        }
    }
    /*var注意
    情况1：没有初始化的局部变量声明
    情况2：方法的返回类型
    情况3：方法的参数类型
    情况4：构造器的参数类型
    情况5：属性
    情况6：catch块
     */
    @Test
    public void test2(){
        //1.局部变量不赋值，就不能实现类型推断
        // var num ;

        //2.Lambda表示式中，左边的函数式接口不能声明为var
        // Supplier<Double> sup=()-> Math.random();
        // var sup=()-> Math.random();

        //3.方法引用中，左边的函数式接口不能声明为var
        // Consumer<String> con = System.out::println;
        // var con = System.out::println;

        //4.数组的静态初始化中，注意如下的情况也不可以
        int[]arr = {1,2,3,4};
        // var arr = (1,2,3,4);
    }

    //java1e的新特性二：集合中新增的copyof()，用于创建一个只读的集合
    @Test
    public void test5() {
        //示例1：
        var list1 = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1); // true
        //示例2:
        var list2 = new ArrayList<String>();
        list2.add("aaa");
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2);//false

        //示例1和2代码基本一致，为什么一个为true，一个为false?
        //结论：copyof(Xxx coll)：如果参数coll本身就是一个只读集合，则copyof()返回值即为
        //如果参数coll不是一个只读集合，则copyof()返回一个新的集合，这个集合是只读的。
    }
}
