package com.ERR2.java;

/*
 * 	自定义异常类
 * 	
 * 	1.继承与现有的异常结构：RuntimeException、Exception
 * 	2.提供全局常量：serialVersionUID
 * 	3.提供重载的构造器
 * 
 */

public class MyException extends RuntimeException{

	static final long serialVersionUID = -7034897190745766939L;
	
	//构造器
	public MyException() {
	}
	public MyException(String msg) {
		super(msg);
	}
	
}
