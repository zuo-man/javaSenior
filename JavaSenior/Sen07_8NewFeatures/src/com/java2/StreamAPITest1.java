package com.java2;

import com.java1.EmployeeData;
import com.team.domain.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @create 2021-10-31 15:34
 */
public class StreamAPITest1 {
    //1.筛选与切片
    @Test
    public void test1(){
        List<Employee> l1 = EmployeeData.getEmployees();//获取Employee数据
        //filter(Predicate p)——接收 Lambda ，从流中排除某些元素
        Stream<Employee> S1 = l1.stream();
        //查询员工年龄大于20的信息
        //方法一：
//        Stream<Employee> s = S1.filter(new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge()>20;
//            }
//        });
//        s.forEach(System.out::println);
        //方法二：
        S1.filter(e -> e.getAge() > 20).forEach(System.out::println);//filter过滤

        System.out.println("****");

        //Limit(n)——截断流，使其元素不超过给定数量
        //因为前面已经forEach终止，所以要重新生成新的l1.stream()
        //获取前2个数据
        l1.stream().limit(2).forEach(System.out::println);

        System.out.println("****");

        //skip(n)——跳过元素（与limit互补），返回一个去除了前n个元素的流。若流中元素不足n个，则返回一个空流（啥也没有）
        //跳过前一个元素，输出后面元素
        l1.stream().skip(1).forEach(System.out::println);

        System.out.println("****");

        //distinct()——筛选，通过流所生成元素的hashCode() 和 equals() 去除重复元素
        l1.add(new Employee(1011,"千姬",19,3999));
        l1.add(new Employee(1011,"千姬",19,3999));
        l1.add(new Employee(1011,"千姬",19,3999));

        l1.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
        //map(Function f)--接收一个函数作为参数，将元素转换为其他形式或提取信息，该函数会被应用到每个元素上，
        //并将其映射成一个新的元素
        List<String> l1 = Arrays.asList("aa","bb","cc");
        l1.stream().map(s -> s.toUpperCase()).forEach(System.out::println);//toUpperCase()转大写

        //获取员工姓名长度大于1的信息
        List<Employee> e = EmployeeData.getEmployees();
        Stream<String> name = e.stream().map(s -> s.getName());//或者写成：e.stream().map(Employee::getName)
        name.filter(n1 -> n1.length() > 1).forEach(System.out::println);

        System.out.println("****");

        //flatMap(Function f)--接收一个函数作为参数，将流中的每一个值都换成另一个流，
        //        然后把所有流连接成一个流
        // map相当于add，会把a2中所有元素作为一个元素赋值。flatMap相当于addAll，把所有数据统一连接成一个赋值
        Stream<Character> c1 = l1.stream().flatMap(StreamAPITest1::fromStringToString);
        c1.forEach(System.out::println);

        ArrayList a1 = new ArrayList();
        a1.add(1);
        ArrayList a2 = new ArrayList();
        a2.add(2);

        //a1.add(a2);
        a1.addAll(a2);
        System.out.println(a1);
    }

    //将字符串中的多个字符构成的集合转化为对应的Stream的实例
    private static Stream<Character> fromStringToString(String s) {//aa
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : s.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    //3-排序
    @Test
    public void test3(){
        //sorted()——自然排序
        List<Integer> l1 = Arrays.asList(12,23,-1,0);
        l1.stream().sorted().forEach(System.out::println);
        //抛异常，原因：要么Employee实现Comparable接口，要么sorted定制排序
//        List<Employee> e = EmployeeData.getEmployees();
//        e.stream().sorted().forEach(System.out::println);


        //sorted(Comparator com)——定制排序
        //方式一：
//        List<Employee> e = EmployeeData.getEmployees();
//        e.stream().sorted(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return Integer.compare(o1.getAge(),o2.getAge());
//            }
//        }).forEach(System.out::println);
        //方式二：
        List<Employee> e = EmployeeData.getEmployees();
        e.stream().sorted((o1,o2) -> Integer.compare(o1.getAge(),o2.getAge())).forEach(System.out::println);
    }
}
