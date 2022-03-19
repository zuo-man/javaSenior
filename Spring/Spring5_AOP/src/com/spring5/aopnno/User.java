package com.spring5.aopnno;

import org.springframework.stereotype.Component;

//被增强的类
@Component
public class User {

    public void add(){
//        int i = 22/0;

        System.out.println("add...");
    }
}
