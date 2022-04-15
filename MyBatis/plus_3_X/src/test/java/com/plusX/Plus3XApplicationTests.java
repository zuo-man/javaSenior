package com.plusX;

import com.plusX.mapper.UserMapper;
import com.plusX.pojo.User;
import com.plusX.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Plus3XApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testX1(){
        List<User> result = userMapper.selectByAgeAndUserName(1, "小优");
        System.out.println(result);
    }

    @Test
    public void testX2(){
        List<User> result = userService.selectAgeUserName(1, "小优");
        System.out.println(result);
    }

}
