package com.plus;

import com.plus.service.ProductService;
import com.plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MultipleTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Test
    public void test1(){

        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));

    }

}
