package com.ERR.java;

import java.util.Date;

import org.junit.Test;

/*
 * 	一：异常体系的结构：
 * 
 * 	java.lang.Throwble
 * 		|----java.lang.Error:一般不编写针对性的代码进行处理
 * 		|----java.lang.Exception:可以进行异常处理
 * 			|-----编译时异常（checked）
 * 			|-----运行时异常（unchecked）
 * 
 */

public class ExceptionTest {
	//NullPointerException空指针异常
	@Test
	public void test1() {
//		int[] arr = null;
//		System.out.println(arr[3]);	
		
		String str = "abc";
		str = null;
		System.out.println(str.charAt(0));	
	}
	
	//IndexOutOfBoundsException角标越界
	@Test
	public void test2() {
		//ArrayIndexOfBoundsException数组角标越界
//		int[] arr = new int[10];
//		System.out.println(arr[10]);
		
		String str = "abc";
		System.out.println(str.charAt(3));	
	}
	
	//ClassCastException类型转换异常
	@Test
	public void test3() {
		Object obj = new Date();
		String str = (String)obj;
		
	}
	
	//ArithmeticExcekption算术异常
	@Test
	public void test4() {
		int a = 10;
		int b = 0;
		System.out.println(a/b);
	}
	

}
