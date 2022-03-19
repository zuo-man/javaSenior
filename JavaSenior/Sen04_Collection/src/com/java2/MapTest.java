package com.java2;

import org.junit.Test;

import java.util.*;

/**
 *     /---Map接口：双列集合，用来存储一对(key - value)一对的数据  --->函数：y = f(x)  value = key
 *          /---HashMap：作为Map的主要实现类：线程不安全的，效率高、存储null的key 和 value
 *                 /---LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                                    原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *                                    对于频繁的遍历操作，此类执行效率高于HashMap
 *
 *          /---TreeMap：保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                       底层使用红黑树
 *          /---Hashtable：作为古老的实现类：线程安全的，效率低、不能存储null的key 和 value
 *                  /---Properties：常用来处理配置文件。key和value都是String类型
 *
 *
 *  二、Map结构的理解：
 *      Map中的key：无序的、不可重复的，使用Set存储所有的key --->key所在的类要重写equals()和hashCode() （以HashMap为例)
 *      Map中的value：无序的、可重复的，使用Collection存储所有的value--->value所在的类要重写equals()
 *      一个键值对：kev-value构成了一个Entrv对象。
 *      Map中的entry:无序的、不可重复的，使用Set存储所有的entry
 *
 *  三、HashMap的底层实现原理？以jdk7为例说明：
 *      HashMap map = new HashMap():
 *      在实例化以后，底层创建了长度是16的一维数组Entry[] table。
 *      ...可能已经执行过多次put...
 *      map.put(key1,value1):
 *      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
 *      如果此位置上的数据为空，此时的key1-value1添加成功。   ---情况1
 *      如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在))，比较key1和已经存在的一个或多个数据
 *      的哈希值：
 *              如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。   ---情况2
 *              如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)的方法
 *                      如果equals()返回false：此时key1-value1添加成功。     ---情况3
 *                      如果equals()返回true：使用value1替换value2。
 *
 *
 *      补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *
 *      在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *      jdk8 相较于jdk7在底层实现方面的不同：
 *      1. new HashMap()：底层没有创建一个长度为16的数组
 *      2.jdk 8底层的数组是：Node[]，而非Entry[]
 *      3.首次调用put()方法时，底层创建长度为16的数组
 *      4.jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
 *          当数组的某一个索引位置上的元素以链表形式存在的数据个数>8 且当前数组的长度>64时，
 *          此时此索引位置上的所有数据改为使用红黑树存储。
 *
 *
 *
 * @create 2021-10-21 17:23
 */
public class MapTest {
    /*
    * 五、Map中定义的方法：
        添加、删除、修改操作：
        Object put(Object key,Object value):将指定key-value添加到(或修改)当前map对象中
        void putAll(Map m)：将m中的所有key-value对存放到当前map中
        Object remove(Object key)：移除指定key的key-value对，并返回value
        void clear()：清空当前map中的所有数据

    总结：常用方法
    添加：put(Object key,Object value)
    删除：remove(Object key)
    修改：put(Object key,Object value)
    查询：get(Object key)
    长度：size()
    遍历：keySet() / value() / entrySet()
     */
    @Test
    public void test1(){
        Map map = new HashMap();
        //添加
        map.put("AA",12);/*将指定key-value添加到(或修改)当前map对象中*/
        map.put(3,3);
        //修改
        map.put("AA",13);

        Map M1 = new HashMap();
        M1.put("BB",12);
        map.putAll(M1);/*将m中的所有key-value对存放到当前map中*/

        System.out.println(map);

        //remove(Object key)
        Object V = map.remove(3);/*将除指定key的key-value对，并返回value*/
        System.out.println(V);
        System.out.println(map);

        //clear()
        map.clear();//与map = null操作不同
        System.out.println(map.size());/*清空当前map中的所有数据*/
        System.out.println(map);
    }
    /*
        元素查询的操作：
        Object get(Object key)：获取指定key对应的value
        boolean containsKey(Object key)：是否包含指定的key
        boolean containsValue(Object value)：是否包含指定的value
        int size()：返回map中key-value对的个数
        boolean isEmpty()：判断当前map是否为空
        boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",12);
        map.put("BB",12);
        map.put(3,3);

        //Object get(Object key)
        System.out.println(map.get("AA"));/*获取指定key对应的value*/

        //containsKey(Object key)
        boolean isExit = map.containsKey("AA");/*是否包含指定的key*/
        System.out.println(isExit);
        //containsValue(Object key)
        isExit = map.containsValue(12);/*是否包含指定的value*/
        System.out.println(isExit);//识别一个就返回true

        //int size()
        System.out.println(map.size());/*返回map中key-value对的个数*/
        //boolean isEmpty()
        System.out.println(map.isEmpty());/*判断当前map是否为空*/
    }
    /*
        元视图操作的方法：
        Set keySet()：返回所有key构成的Set集合
        Collection values()：返回所有value构成的Collection集合
        Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test3(){
        Map M1 = new HashMap();
        M1.put("AA",12);
        M1.put("BB",12);
        M1.put(3,3);

        //遍历所有的key集：keySet()
        Set S1 = M1.keySet();  /*返回所有key构成的Set集合*/
        Iterator i = S1.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        //遍历所有的value集：values()
        Collection V1 = M1.values();/*返回所有value构成的Collection集合*/
        for(Object o : V1){
            System.out.println(o);
        }

        System.out.println("*********");

        //遍历所有的key-value
        //方式一：entrySet():
        Set E1 = M1.entrySet();/*返回所有key-value对构成的Set集合*/
        Iterator i1 = E1.iterator();
        while (i1.hasNext()){
            Object o = i1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)o;//将object类型强转成Entry类型
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        //方式二：
        Set E2 = M1.keySet();
        Iterator i2 = E2.iterator();
        while (i2.hasNext()){
            Object key = i2.next();
            Object value = M1.get(key);
            System.out.println(key + "===" + value);
        }
    }
}
