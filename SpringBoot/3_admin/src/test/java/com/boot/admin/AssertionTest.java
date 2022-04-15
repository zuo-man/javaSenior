package com.boot.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 简单断言
 * assertEquals 判断两个对象或两个原始类型是否相等
 * assertNotEquals 判断两个对象或两个原始类型是否不相等
 * assertSame 判断两个对象弓I用是否指向同一个对象
 * assertNotSame 判断两个对象弓I用是否指向不同的对象
 * assertTrue 判断给定的布尔值是否为 true
 * assertFalse 判断给定的布尔值是否为 false
 * assertNull 判断给定的对象弓I用是否为 null
 * assertNotNull 判断给定的对象引用是否不为 null
 *
 * 数组断言
 * 通过 assertArrayEquals 方法来判断两个对象或原始类型的数组是否相等
 *
 * 组合断言
 * assertAII 方法接受多个 org.junit.jupiter.api.Executable 函数式接口的实例作为要验证的断
 * 言，可以通过 lambda 表达式很容易的提供这些断言
 *
 * 异常断言
 * Assertions.assertThrows()
 *
 * 超时断言
 * Assertions.assertTimeoutO 为测试方法设置了超时时间
 */
public class AssertionTest {

    /**
     * 断言：前面的断言失败，后面的代码都不会执行
     */

    @Test
    @DisplayName( "数组断言")
    public void array() {
        assertArrayEquals(new int[]{111, 222}, new int[]{1, 2});
    }

    @Test
    @DisplayName("组合断言")
    //需要断言全部成功
    public void all(){
        assertAll("test",
                ()-> assertTrue(true && true, "结果不是true"),
                ()-> assertEquals(1, 2,"结果不是1"));
        System.out.println("all");
    }

    @Test
    @DisplayName("异常断言")
    //断定一定出异常
    public void testException(){
        assertThrows(ArithmeticException.class, ()-> {int i = 10/2 ;}, "业务居然正常运行了");
    }

    @Test
    @DisplayName("快速失败")
    public void testFail(){
        //xxx
        if(1 == 2){
            fail("测试失败");
        }
    }

    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(1, 1);;
        //判断相等
        assertEquals(5, cal, "业务逻辑计算失败");

        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1, o2, "两个对象不一样");
    }

    int cal(int i, int j){
        return i + j;
    }

}
