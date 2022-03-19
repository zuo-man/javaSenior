package com.OO2.java;

/*
 * 	抽象类的应用：模板方法的设计模式
 */

public class TemplateTest {
	public static void main(String[] args) {

		SubTemplate x = new SubTemplate();
		x.spendTime();
				
	}
}


abstract class Template{
	
	//计算某段代码执行时间
	public void spendTime() {
		long start = System.currentTimeMillis();
		
		code();//不确定的部分、异变的部分，之后重写代码
		
		long end = System.currentTimeMillis();
		
		System.out.println("花费的时间为：" + (end - start));
	}
	
	//抽象化code方法,在之后调用时重写
	public abstract void code();
	
}

//子类，重写类
class SubTemplate extends Template{
	
	public void code() {
		//偶数
		for(int i =1; i<=100;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		
	}
}