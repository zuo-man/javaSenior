package com.PackTest.java;

import org.testng.annotations.Test;

/*
 * java 中的Junit单元测试
 * 
 * 步骤：1.选中当前工程-右键选择：build path -add libraries-JUnit4 -下一步
 * 	   2.创建java类，进行单元测试
 * 		  此时java类的要求：①此类是public的   ②此类提供公共的无参构造器
 *     3.此类中声明单元测试的方法。
 *     	  此时的单元测试方法：方法的权限是public，没有返回值，没有形参
 *     
 *     4.此单元测试方法上需要声明注解：@Test。
 *     
 *     5.左键双击单元测试方法名，右键：run as -Junit Test
 *     
 *  说明：
 *  1.如果执行结果没有任何异常：绿条
 *  2.如果执行结果异常：红条
 * 	    
 * 
 */


public class JUnitTest {
	
	int num = 10;
	
	@Test
	public void testEquals() {
		String s1 = "mm";
		String s2 = "mm";
		System.out.println(s1.equals(s2));
	}

}
