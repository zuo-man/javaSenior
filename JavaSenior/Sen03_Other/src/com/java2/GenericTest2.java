package com.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *  一：泛型在继承方面的体现；
 *      虽然类A是类B的父类，但是G<A> 和 G<B>二者不具备父类的关系，二者是并列关系
 *      类A是类B的父类，A<G> 是 B<G>的父类
 *
 *  二：通配符使用
 *      类A是类B的父类，G<A> 和 G<B>是没有关系的，二者共同的父类是：G<?>
 *
 * @create 2021-10-22 15:34
 */
public class GenericTest2 {
    @Test
    public void test1(){
        List<Object> l1 = null;
        List<String> l2 = null;

        List<?> X = null;//作为List<>的通用父类

        X = l1;
        X = l2;


        List<String> l3 = new ArrayList<>();
        l3.add("AA");
        l3.add("BB");
        X = l3;
        //添加（写入）：对于List<?>就不能向其内部添加数据、除了null之外
//        X.add("DD");

        //获取:允许读取数据，读取的数据类型为Object
        Object o = X.get(0);
        System.out.println(o);
    }

    public void print(List<?> list){
        Iterator<?> i = list.iterator();
        while (i.hasNext()){
            Object o = i.next();
            System.out.println(o);
        }
    }

    /*
    有限制条件的通配符使用
        ? extends Father:
                G<? extents A> 可以作为G<A> 和 G<B>的父类的，其中B是A的子类
        ? super Father
                G<? extents A> 可以作为G<A> 和 G<B>的父类的，其中B是A的父类
     */
    @Test
    public void test2(){
        List<? extends Father> l1 = null;// ? <= extends (-∞，father)
        List<? super Father> l2 = null;// ? >= super  (fater,+∞）

        List<Son1> l3 = new ArrayList<Son1>();
        List<Father> l4 = new ArrayList<Father>();
        List<Object> l5 = new ArrayList<Object>();

        l1 = l3;
        l1 = l4;
//      l1 = l5;

//      l2 = l3;
        l2 = l4;
        l2 = l5;

        //读取数据
        l1 = l3;
        Father f1 = l1.get(0);//l1 extends father,<= father 。最小也只能是Fater接收
//      Son S1 = l1.get(0);//编译不通过

        l2 = l4;
        Object o1 = l2.get(0);

//      Father f1 = l2.get(0);//编译不通过
        //写入数据
//      l1.add(new Son1());//编译不通过
        l2.add(new Father());
        l2.add(new Son1());//son1是Father的子类，多态性，可以赋值

    }
}
