package com.boot.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * • @Test:表示方法是测试方法。但是与JUnit4的@Test不同，他的职责非常单一不能声明任何属性，拓展的测试将会由jupiter提供额外测试
 * • @ParameterizedTest:表示方法是参数化测试，下方会有详细介绍
 * • @RepeatedTest :表示方法可重复执行，下方会有详细介绍
 * • @DisplayName:为测试类或者测试方法设置展示名称
 * • @BeforeEach:表示在每个单元测试之前执行
 * • @AfterEach:表示在每个单元测试之后执行
 * • @BeforeAII:表示在所有单元测试之前执行
 * • @AfterAII:表示在所有单元测试之后执行
 * • @Tag:表示单元测试类别，类似于JUnit4中的@Categories
 * • @Disabled:表示测试类或测试方法不执行，类似于」Unit4中的@lgnore
 * • @Timeout:表示测试方法运行如果超过了指定时间将会返回错误
 * • @ExtendWith:为测试类或测试方法提供扩展类引用
 *
 * 加上@SpringbootTest后，就能使用spring测试
 * @Extenwith(SpringExtension.class) ：表示下方的测试使用spring测试
 * @RepeatedTest(5) ： 表示此方法测试 5 次
 */
@DisplayName("junit5功能测试类")
public class Junit5Test {

    @Test
    @DisplayName("测试displayname注解")
    public void testDisplayName(){
        System.out.println(1);
    }

    //@BeforeEach：表示在每个单元测试之前 执行一次          @BeforeAll：表示在所有测试之前执行
    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试开始。。。");
    }
    //@AfterEach：表示在每个测试之后 执行一次               @AfterAll：表示在所有测试之后执行
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了");
    }


    @Test
    @DisplayName("/测试前置条件")
    public void testAssumptions(){

        Assumptions.assumeTrue(true, "结果不是true");
        System.out.println("11111");
    }

}
