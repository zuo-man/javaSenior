package com.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一：java中的对象，正常情况下，只能比较：== !=。不能使用> < 的
 *    开发中，使用接口来进行对象排序：Comparble、Comparator
 *
 * 二：对比
 *    Comparble接口方式一旦确定，保证Comparable接口实现类的对象在任何位置都可以比较带下
 *    Comparator接口属于临时性的比较
 *
 * @create 2021-10-16 10:36
 */
public class CompareTest {
    /*
    Comparable接口的使用：自然排序
    1.String、包装类等实现了Comparable接口，重写compareTo(obj)方法，给出了比较两个对象大小的方式
    2.String、包装类重写comparTo()方法以后，进行了从小到大排列
    3.重写compareTo(obj)的规则：
        如果当前对象this大于形参对象obj，则返回正整数
        如果当前对象this小于形参对象obj，则返回负整数
        如果当前对象this等于形参对象obj，则返回0

    4.对于自定义类排序，让自定义类实现Comparable接口，重写compareTo(obj)方法
      在compareTo(obj)方法中指明如何排序
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","TT","BB","RR","GG"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("裤子",34);
        arr[1] = new Goods("鞋子",567);
        arr[2] = new Goods("衣服",45);
        arr[3] = new Goods("帽子",45);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /*
    Comparator接口的使用：定制排序
    1.背景：
    当元素的类型没有实现java.lang.Comprable接口而又不方便修改代码，
    或者实现了java.lang.Comprable接口的排序规则不适合当前的操作。
    可以考虑使用Conprartor的对象来排序
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小
    如果方法返回正整数，则表示o1大于o2:
    如果返回0，表示相等，
    返回负整数，表示o1小于o2
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","TT","BB","RR","GG"};
        Arrays.sort(arr, new Comparator() {//匿名

            //按照字符从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {//o1,o2 是字符串
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;//父类object强转成子类String类型
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);//不加-，从低到高，加-，从高到低
                }
//                return 0;
                throw new RuntimeException("传入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test4(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("裤子",34);
        arr[1] = new Goods("鞋子",567);
        arr[2] = new Goods("衣服",45);
        arr[3] = new Goods("衣服",234);

        Arrays.sort(arr,new Comparator(){

            //指明商品比较大小：先按名称，再按价格
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;//将父类objict o2强转成子类Good g2
                    if(g1.getName().equals(g2.getName())){//如果商品名字一样
                        return -Double.compare(g1.getPrice(),g2.getPrice());//价格比较大小
                    }else{//如果商品名字不一样，按名称比较大小
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
