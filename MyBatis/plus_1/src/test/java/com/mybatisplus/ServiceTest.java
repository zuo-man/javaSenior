package com.mybatisplus;

import com.mybatisplus.pojo.User;
import com.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectTest(){
        //SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    //批量添加
    @Test
    public void insertsTest(){
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            User user = new User();
            user.setName("无暇" + i);
            user.setAge(18 + i);
            list.add(user);
        }
        //INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }

    //测试UserMapper 自定义方法
    @Test
    public void selectMap(){
        Map<String, Object> map = userService.selectMap(1L);
        System.out.println(map);
    }

}
