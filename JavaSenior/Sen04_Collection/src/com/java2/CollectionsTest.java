package com.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * Collectiongs:操作Collection、Map的工具类
 *
 * 线程安全转换
 *
 * @create 2021-10-21 21:30
 */
public class CollectionsTest {
    /*
    Collections类中提供了多个synchronizedXxx() 方法，
    该方法可使将指定集合包装成线程同步的集合，从而可以解决
    多线程并发访问集合时的线程安全问题
     */
    @Test
    public void T(){
        List l1 = new ArrayList();
        l1.add(123);

        List L = Collections.synchronizedList(l1);//该线程就是线程安全的了
    }


    /*
    everse(List)：反转 List 中元素的顺序
    shuffle(List)：对 List 集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
    sort(List, Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
    swap(List, int,int)：将指定List 集合中的  处元素和j处元素进行交换

    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection, Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最)
    Object min(Collection, Comparator)
    int frequency(Collection, Object)：返回指定集合中指定元素的出现次数
    void copy(List dest,List src)：将src中的内容复制到dest中
    boolean replaceAll(List list, Object oldVal, Object newVal)：使用新值替换List 对
     */
    @Test
    public void test1(){
        List l1 = new ArrayList();
        l1.add(123);
        l1.add(9);
        l1.add(44);
        l1.add(44);

        System.out.println(l1);

        Collections.reverse(l1);/*反转 List 中元素的顺序*/
//        Collections.shuffle(l1);/*对 List 集合元素进行随机排序*/
//        Collections.sort(l1);/*根据元素的自然顺序对指定 List 集合元素按升序排序*/
//        Collections.swap(l1,1,2);/*将指定List 集合中的  处元素和j处元素进行交换*/

        System.out.println(l1);

        int F1 = Collections.frequency(l1,44);/*返回指定集合中指定元素的出现次数*/
        System.out.println(F1);
    }

    @Test
    public void test2(){
        List l1 = new ArrayList();
        l1.add(123);
        l1.add(9);
        l1.add(44);

        List D1 = Arrays.asList(new Object[l1.size()]);
        System.out.println(D1.size());//list.size();
        Collections.copy(D1,l1);/*将src中的内容复制到dest中*/

        System.out.println(D1);
    }
}
