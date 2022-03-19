package com.OO4.java;

/*	接口:
 * 	JDK8,除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 * 
 */

public interface Interface8 {
	
	//静态方法
	public static void method1() {
		System.out.println("AAAA");
	}

	//默认方法
	public default void method2() {
		System.out.println("BBBB");
	}
	default void method3() {//public 可以省略
		System.out.println("CCCC");
	}
}

