package com.OO.java;

/*
 * final:最终的
 * 
 * 1.final 可以用来修饰的结构：类、方法、变量j
 * 
 * 2.final 用来修饰一个类：此类不能被其他类所继承
 * 			比如：String类、System类、StringBuffer类
 * 
 * 3.final 修饰方法，表明此方法不可被重写
 * 			比如：Object中的getClss（）
 * 
 * 4.final 修饰变量：此时的“变量”就称为是一个常量
 * 		4.1 修饰属性：可以考虑赋值的位置有：显式初始化、代码块中的初始化、构造器中的初始化
 * 		4.2 修饰局部变量：
 * 			修饰形参时，表明此形参是一个常量。调用此方法时，给常量形参赋一个实参，一但赋值
 * 			以后，就只能在方法体内使用此形参，但不能进行重新赋值
 * 
 * static final ：用来修饰属性：全局常量
 * 
 */

public class FinalTest {

	final int width = 1;
	final int left;
	final int rigth;
	
	{
		left =1;
	}
	
	public FinalTest() {
		rigth = 2;
	}
	
	
	public void dowidth() {
//		width = 2;
		final int xxj=1;//常量
//		xxj +=2;
	}
	
	public void hig(final int num) {
//		num = 1;
	}
	
}


final class FinalA{
	
}



//class B extends FinalA{
//	
//}

class AA{
	public final void show() {
		
	}
}
//class BB extends AA{
//	public final void show() {
//		
//	}
//}


