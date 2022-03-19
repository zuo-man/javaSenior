package com.spring5.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userDaoImplXXX")
public class UserDaoImplXXX implements UserDao{

    @Override
    public void add() {
        System.out.println("DAO层XXX add方法调用...");
    }
}
