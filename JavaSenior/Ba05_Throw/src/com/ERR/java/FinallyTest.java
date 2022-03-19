package com.ERR.java;

import org.junit.Test;

/*
 * try-catch-finally中finally的使用
 * 
 * 	1.finally是可选的
 * 	2.finally中声明的是一定会被执行的代码，即使catch中又出现异常了。
 * 	  try中有return语句，catch中有return语句等情况
 * 
 * 	3.像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动的回收的，则需要
 * 	    手动进行资源的释放。此时资源的释放，就需要声明在finally中
 * 
 * 	方法重写规则之一：
 * 	子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 * 
 */

public class FinallyTest {

	@Test
	public void test1() {
		try {
			int a = 10;
			int b =0;
			System.out.println(a/b);
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}finally {
			System.out.println("一定执行");
		}	
	}
	
	
	
	
}
