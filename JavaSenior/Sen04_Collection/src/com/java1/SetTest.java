package com.java1;

import com.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 *      Set接口的框架
 *
 *      /---Collection接口：单列集合，用来存储一个一个的对象
 *           /---Set接口：存储无序的、不可重复的数据  --->高中的"集合"
 *
 *              /---HashSet：作为Set接口的主要实现类：线程不安全的，可以存储null值
 *                  /---LinkedHashSet：作为HashSet的子类：遍历其内部数据时，可以按照添加的顺序排序
 *                                     对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 *              /---TreeSet：可以按照添加对象的指定属性，进行排序
 *
 *  1.Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法
 *
 *  2.要求：向Set中添加的数据，其所在类一定要重写hashCode()和equals()
 *    要求：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 *
 * @create 2021-10-21 10:54
 */
public class SetTest {
    /*
    Set:存储无序的、不可重复的数据
    以HashSet为例说明：
    1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定

    2.不可重复性：保证添加的元素按照equals()判断时，不能返回true，即：相同元素只能添加一个

    二、添加元素的过程：以HashSet为例：
            我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
            此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置(即为：索引位置)，判断
            数组此位置上是否已经有元素：
                如果此位置上没有其他元素，则元素a添加成功。--->情况1
                如果此位置上有其他元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的hash值：
                    如果hash值不相同，则元素a添加成功。--->情况2
                    如果hash值相同，进而需要调用元素a所在类的equlas()方法：
                        equals()返回true，元素a添加失败
                        equals()返回false，则元素a添加成功。--->情况2

            对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上数据以链表的方式存储。
            jdk7：元素a放到数组中，指向原来的元素。jdk 8：原来的元素在数组中，指向元素a
            总结：七上八下

            HashSet底层：数组+链表的结构
     */
    @Test
    public void test1(){
        Set S1 = new HashSet();
        S1.add(12);
        S1.add(12);
        S1.add("AA");
        S1.add(new Person("艾琳",12));
        S1.add(new Person("艾琳",12));

        Iterator i = S1.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }

    //LinkedHashSet使用
    /*LinkedHashSet作为HashSet子类，在添加数据同时，每个数据还维护了两个引用，记录此数据前一个和后一个数据。链表
      对于频繁的遍历操作，LinkedHashSet效率高于HashSet*/
    @Test
    public void test2(){
        Set S1 = new LinkedHashSet();
        S1.add(12);
        S1.add(12);
        S1.add("AA");
        S1.add(new Person("艾琳",12));

        Iterator i = S1.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
