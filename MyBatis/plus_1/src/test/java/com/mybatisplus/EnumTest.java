package com.mybatisplus;

import com.mybatisplus.enums.SexEnum;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = new User(null,"格兰尼", SexEnum.FEMALE, 21, "123",null);
        //INSERT INTO t_user ( user_name, sex, age, email ) VALUES ( ?, ?, ?, ? )
        int result = userMapper.insert(user);
        System.out.println("result ：" + result);
    }

}
