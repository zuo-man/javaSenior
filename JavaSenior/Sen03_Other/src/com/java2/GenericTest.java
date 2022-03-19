package com.java2;

import org.junit.Test;

import java.util.*;
/**
 * 泛型
 *
 * ①在实例化集合类是，可以指明具体的泛型类型
 * ②在集合类或接口凡是定义类或接口时，内部结构（比如：方法、构造器、属性），使用
 *      到类的泛型的位置，都指定唯实例化的泛型类型
 *      比如：add(E e) --->实例化以后：add(Integer e)
 * ③注意：泛型的类型必须是类，不能是基本数据类型（应用包装类）
 * ④实例化没有指明泛型类型，默认类型为Object
 *
 * @create 2021-10-22 11:23
 */
public class GenericTest {
    //以ArrayList为例
   @Test
   public void test1() {
       ArrayList<Integer> A1 = new ArrayList<>();//不能使用基本数据类型，要用包装类
                          //shift + f6 ：同一修改同一变量名

       A1.add(12);
       A1.add(23);

       //编译时，就会类型检查，保证数据的安全
//       l1.add("小优");

       //方式一：增强for循环
       for(Integer score : A1){
           //避免了强转操作
           int S1 = score;
           System.out.println(S1);
       }
       //方式二：迭代器
       Iterator<Integer> i1 = A1.iterator();
       while (i1.hasNext()){
           System.out.println(i1.next());
       }
   }
    //以ArrayList为例
   @Test
   public void test2(){
//       Map<String,Integer> M1 = new HashMap<String,Integer>();
       Map<String,Integer> M1 = new HashMap<>();//类型推断，后面泛型类型可以省略不写

       M1.put("小优",23);
       M1.put("无暇",18);

       Set<Map.Entry<String,Integer>> E1 = M1.entrySet();
       Iterator<Map.Entry<String,Integer>> I1 = E1.iterator();

       while (I1.hasNext()){
           Map.Entry<String, Integer> e = I1.next();

           System.out.println(e.getKey() + "--->" + e.getValue());
//           System.out.println(e);
       }
   }
}
