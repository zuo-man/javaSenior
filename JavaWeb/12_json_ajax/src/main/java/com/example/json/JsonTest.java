package com.example.json;

import com.example.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.*;

/**
 * @create 2022-01-11 13:51
 */
public class JsonTest {
    //1.2.1  javavBean和json的互转
    @Test
    public void test1(){
        Person person = new Person(1,"小优");
        //创建Gson对象实例
        Gson gson = new Gson();

        //toJson方法可以把java对象转换成json字符串
        String jsonString = gson.toJson(person);
        System.out.println(jsonString);

        /*
        fromJson把json字符串转换回Java对象
        第一个参数是json字符串
        第二个参数是转换回去的Java对象类型
         */
        Person person1 = gson.fromJson(jsonString, Person.class);
        System.out.println(person1);
    }

    //1.2.2 List和json的互转
    @Test
    public void test2(){
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(1,"小优"));
        personList.add(new Person(2,"无暇"));

        Gson gson = new Gson();

        //把List转换为json字符串
        String ListJsonString = gson.toJson(personList);
        System.out.println(ListJsonString);

        /*
        转换回List，需要写一个类继承TypeToken，且泛型需要写转换的类型
         */
        List<Person> list = gson.fromJson(ListJsonString, new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }

    //1.2.3 map和json的互转
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();

        personMap.put(1, new Person(1,"小优"));
        personMap.put(2, new Person(2,"无暇"));

        Gson gson = new Gson();
        //把map集合转换为 Json字符串
        String MapJson = gson.toJson(personMap);

        System.out.println(MapJson);

        /*
        转换回Map，需要写一个类继承TypeToken，且泛型需要写转换的类型
        或者用匿名对象，直接new
         */
//        Map<Integer, Person> personMap1 = gson.fromJson(MapJson, new PersonMayType().getType());
        Map<Integer, Person> personMap1 = gson.fromJson(MapJson, new TypeToken<HashMap<Integer, Person>>(){}.getType());

        System.out.println(personMap1);
        Person person = personMap1.get(1);
        System.out.println(person);
    }

}
