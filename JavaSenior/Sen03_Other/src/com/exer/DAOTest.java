package com.exer;

import java.util.List;

/**
 * @create 2021-10-22 19:12
 */
public class DAOTest {
    public static void main(String[] args) {

        DAO<User> D1 = new DAO<User>();

        D1.save("1001",new User("无暇",1,18));//(String id,User data)
        D1.save("1002",new User("小真",2,20));
        D1.save("1003",new User("唯",3,21));

        D1.update("1002",new User("千姬",4,4));


        List<User> l1 = D1.list();
//        System.out.println(l1);

        l1.forEach(System.out::println);
    }
}
