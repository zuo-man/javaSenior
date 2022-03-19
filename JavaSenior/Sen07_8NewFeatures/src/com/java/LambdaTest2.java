package com.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置4大函数式接口
 *
 * 消费型接口 Comsumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 *
 * @create 2021-10-31 12:35
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        sup(100,new Consumer<Double>(){//sup方法调用，100先作为money形参传入到sup方法里赋值给(money)，
                                              //重写的方法accept作为con传入到sup中，100再冲money赋值给重写方法mai中
            @Override
            public void accept(Double mai) {
                System.out.println("购物花了:" + mai);
            }
        });

        sup(1,water -> System.out.println("买水花了" + water));
    }
    public void sup(double money, Consumer<Double> con){//消费型接口 Comsumer
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> l1 = Arrays.asList("小优","小真","小千","无暇");
        List<String> F = filterString(l1, new Predicate<String>() {
            @Override
            public boolean test(String x) {                               //集合元素小优，调用filterString方法，作为形参list赋值给for循环s中，
                return x.contains("小");//返回的是booleantrue或false       //再由传入方法pre到重写方法test中，赋值给A1
            }
        });
        System.out.println(F);

        List<String> F2 = filterString(l1,x -> x.contains("无"));
        System.out.println(F2);
    }

    //根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){//参数1：传进l1集合。 参数2：传进重写的test方法

        ArrayList<String> A1 = new ArrayList<>();

        for(String s : list){
            if(pre.test(s)){//判断是否为true
                A1.add(s);
            }
        }
        return A1;
    }
}
