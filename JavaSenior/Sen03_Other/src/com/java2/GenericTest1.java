package com.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类实例化
 *
 * @create 2021-10-22 13:49
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //当定义泛型类，实例化时没有指明类的泛型，则认为此泛型为Object类型

        //建议：实例化时指明类的泛型
        Order<String> O1 = new Order<>("小优",20,"拍照");//指明泛型T是String类型

        O1.setT("跑步");
        System.out.println(O1);




        //测试泛型方法
        Integer[] arr = new Integer[]{1,23,42};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> L = copyFromArrays(arr);
        System.out.println(L);
    }


    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //         泛型方法所属的类是不是泛型类都没有关系
    //泛型方法可以声明为静态的。原因：泛型参数是在调用方法时确定的，并非在实例化时确定的
    public static <E> List<E> copyFromArrays(E[] arr){

        ArrayList<E> l1 = new ArrayList<>();

        for(E e : arr){
            l1.add(e);
        }
        return l1;
    }
}
