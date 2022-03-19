package com.spring5.text;

import com.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Spring5 支持整合 JUnit4
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:druid.xml") //加载配置文件
public class JTest5 {
    @Autowired
    private UserService userService;

    @Test
    public void testAccount(){

        userService.account();
    }
}
