package com.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * （1）@Nullable 注解可以使用在方法上面，属性上面，参数上面，表示方法返回可以为空，属性值可以
     *      为空，参数值可以为空
     * （2）注解用在方法上面，方法返回值可以为空
     * （3）注解使用在方法参数里面，方法参数可以为空
     * （4）注解使用在属性上面，属性值可以为空
     */
    @Nullable
    private String bookName;

    //少钱方法
    @Override
    public void reduceMoney() {
        String sql = "update account set money=money-? where name=?";
        jdbcTemplate.update(sql, 100, "小优");
    }

    //多钱方法
    @Override
    public void addMoney() {
        String sql = "update account set money=money+? where name=?";
        jdbcTemplate.update(sql, 100, "无暇");
    }
}
