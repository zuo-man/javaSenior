package com.java2;

import com.java.Person;
import org.junit.Test;

import java.util.*;

/**
 * @create 2021-10-21 20:36
 */
public class TreeMapTest {
    //向TreeMap中添加key-value,要求key必须是由一个类创建的对象
    //自然排序(排序只能按照key排序)
    @Test
    public void test1(){
        TreeMap T1 = new TreeMap();
        Person P1 = new Person("千姬",19);
        Person P2 = new Person("丽达",22);
        Person P3 = new Person("唯",21);
        T1.put(P1,100);
        T1.put(P2,98);
        T1.put(P3,96);

        Set E1 = T1.entrySet();/*返回所有key-value对构成的Set集合*/
        Iterator i1 = E1.iterator();
        while (i1.hasNext()){
            Object o = i1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    //定制排序(排序只能按照key排序)
    @Test
    public void test2(){
        //使用泛型
        TreeMap T1 = new TreeMap(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {//不需要instanceof和强转
                return Integer.compare(o1.getAge(),o2.getAge());//按年龄排序
            }
        });
        //不使用泛型
//        TreeMap T1 = new TreeMap(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Person && o2 instanceof Person){
//                    Person p1 = (Person)o1;
//                    Person p2 = (Person)o2;
//                    return Integer.compare(p1.getAge(), p2.getAge());//按年龄排序
//                }
//                throw new RuntimeException("输入的类型不匹配");
//            }
//        });

        Person P1 = new Person("千姬",19);
        Person P2 = new Person("丽达",22);
        Person P3 = new Person("唯",21);
        T1.put(P1,100);
        T1.put(P2,98);
        T1.put(P3,96);

        Set E1 = T1.entrySet();/*返回所有key-value对构成的Set集合*/
        Iterator i1 = E1.iterator();
        while (i1.hasNext()){
            Object o = i1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
}
