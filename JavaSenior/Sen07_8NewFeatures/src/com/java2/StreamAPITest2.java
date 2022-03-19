package com.java2;

import com.java1.EmployeeData;
import com.team.domain.Employee;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * 终止操作
 *
 * @create 2021-11-01 19:37
 */
public class StreamAPITest2 {
    //匹配与查找
    @Test
    public void test1(){
        List<Employee> e = EmployeeData.getEmployees();

        //allMatch(Predicate p)——检查是否匹配所有元素
        //是否所有员工年龄都大于20
        boolean b1 = e.stream().allMatch(s -> s.getAge() > 20);
        System.out.println(b1);

        //anyMatch(Predicate p)——检查是否至少匹配一个元素
        //是否存在员工工资大于2000
        boolean b2 = e.stream().anyMatch(s -> s.getSalary() > 2000);
        System.out.println(b2);

        //noneMatch(Predicate p)——检查是否没有匹配的元素
        //是否存在员工姓“千”
        boolean b3 = e.stream().noneMatch(s -> s.getName().startsWith("千"));//startsWith开头信息
        System.out.println(b3);

        //findFirst——返回第一个元素
        Optional<Employee> o1 = e.stream().findFirst();
        System.out.println(o1);

        //findAny——返回当前流中的任意元素
        Optional<Employee> o2 = e.parallelStream().findAny();//stram并行流(也叫顺序流)，parallelStream串行流
        System.out.println(o2);
    }
    @Test
    public void test2(){
        List<Employee> e = EmployeeData.getEmployees();

        //cont——返回流中元素的总个数
        long c1 = e.stream().filter(s -> s.getSalary() > 2000).count();//筛选后再返回流中元素个数
        System.out.println(c1);

        //max(Comparator c)——返回流中最大轴
        //返回最高的工资
        Stream<Double> s1 = e.stream().map(s -> s.getSalary());//映射map为Stream数据赋值s1
        //方法一：
//        Optional<Double> max1 = s1.max(new Comparator<Double>() {
//            @Override
//            public int compare(Double o1, Double o2) {
//                return Double.compare(o1,o2);
//            }
//        });
        //方法二：
//        Optional<Double> max2 = s1.max((o1,o2) -> Double.compare(o1,o2));
        //方法三：
        Optional<Double> max3 = s1.max(Double::compareTo);
        System.out.println(max3);

        //min(Comparator c)——返回流中最小值
        //返回最低工资的员工
        Optional<Employee> min = e.stream().min((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()));
        System.out.println(min);

        //forEach(Comsumer c)——内部迭代
//        e.stream().forEach(System.out::println);

        //使用集合的遍历操作
        e.forEach(System.out::println);
    }

    //归纳
    @Test
    public void test3(){
        //reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值，返回T
        //计算1-2再加10之和
        List<Integer> l1 = Arrays.asList(1,2);
        //方式一：
        Integer re1 = l1.stream().reduce(10, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer o1, Integer o2) {
                return Integer.sum(o1,o2);
            }
        });
        //方式二：
        Integer re2 = l1.stream().reduce(10, (o1, o2) -> Integer.sum(o1, o2));
        //方式三：
        Integer re3 = l1.stream().reduce(10,Integer::sum);
        System.out.println(re3);


        //reduce(BinaryOperator)——可以将流中元素反复结合起来，得到一个值，返回Optional<T>
        //计算公司所有员工工资总和
        List<Employee> e = EmployeeData.getEmployees();
        Stream<Double> s1 = e.stream().map(Employee::getSalary);//映射map只获取员工工资赋值为s1

        Optional<Double> o = s1.reduce(Double::sum);
        System.out.println(o);
    }

    //收集
    @Test
    public void test4(){
        List<Employee> e = EmployeeData.getEmployees();

        //collect(Collector c)——将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        //查找工资大于2000的员工，结果返回为一个List或Set
        List<Employee> l1 = e.stream().filter(s -> s.getSalary() > 2000).collect(Collectors.toList());
        l1.forEach(System.out::println);

        System.out.println("****");

        //返回一个Set
        Set<Employee> s1 = e.stream().filter(s -> s.getSalary() > 2000).collect(Collectors.toSet());
        System.out.println(s1);//输出集合元素
        s1.forEach(System.out::println);//输出遍历集合
    }
}
