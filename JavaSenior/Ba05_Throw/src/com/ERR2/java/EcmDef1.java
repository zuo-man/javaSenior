package com.ERR2.java;

//自定义异常类

public class EcmDef1 extends Exception{

	static final long serialVersionUID = -3387516993124229948L;//提供全局常量
	
	//提供构造器
	public EcmDef1() {
	};
	
	public EcmDef1(String msg) {
		super(msg);
	}
	
}
