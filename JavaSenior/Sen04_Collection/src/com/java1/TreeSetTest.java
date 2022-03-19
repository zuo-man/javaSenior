package com.java1;

import com.java.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
/**
 * TreeSet
 *
 * @create 2021-10-21 15:23
 */
public class TreeSetTest {
    /*
    1.向TreeSet中添加数据，要求是相同类的对象
    2.两种排序方式：自然排序 和 定制排序

    3.自然排序中，比较两个对象是否相同标准为：compreTo()返回0，不再是equals()
      定制排序中，比较两个对象是否相同标准为：compre()返回0，不再是equals()
     */
    @Test
    public void test1(){
        TreeSet<Person> S1 = new TreeSet<>();

        //按大小排序
//        S1.add(23);
//        S1.add(-1);
//        S1.add(234);

        //自定义排序，Person需要继承Comparable重写方法。否则异常
        S1.add(new Person("小优",23));
        S1.add(new Person("无暇",18));
        S1.add(new Person("千姬",16));
        S1.add(new Person("千姬",20));

        Iterator<Person> i = S1.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }

    @Test
    public void test2(){
        Comparator C1 = new Comparator() {
            //按年龄从小到大排列,相同年龄不录入。要想录入，加if return的数等于0，则年龄一样，else比较其他。
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person P1 = (Person)o1;
                    Person P2 = (Person)o2;
                    return Integer.compare(P1.getAge(),P2.getAge());
                }else {
                    throw new RuntimeException("输入的类型不匹配");
                }
            }
        };

        TreeSet S1 = new TreeSet(C1);
        S1.add(new Person("小优",23));
        S1.add(new Person("无暇",18));
        S1.add(new Person("千姬",18));

        Iterator i = S1.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
