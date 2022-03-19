package com.spring5.text;

import com.spring5.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Spring5 支持整合 JUnit5
 */

//@RunWith(SpringJUnit4ClassRunner.class) //单元测试框架
//@ContextConfiguration("classpath:druid.xml") //加载配置文件

@SpringJUnitConfig(locations = "classpath:druid.xml")    //可以代替上面两个注解

public class JText4 {
    @Autowired
    private UserService userService;

    @Test
    public void testAccount(){

        userService.account();
    }
}
