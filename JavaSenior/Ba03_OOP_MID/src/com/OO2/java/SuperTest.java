package com.OO2.java;

/*
 * super关键字的使用
 * 1.super理解为：父类的
 * 2.super可以用来调用：属性、方法、构造器
 * 
 * 3.super的使用：
 * 		3.1 我们可以在字类的方法或构造器中，通过使用“super.属性”或“super.方法”的方式，显式的调用
 * 			父类中声明的属性或方法。通常情况下，省略super
 * 		3.2 特殊情况：当字类和父类定义了同名的属性时，想在字类中调用父类中声明属性，则必须显式的使用
 * 			”super.属性“的方式。表明调用的是父类中声明的属性。
 * 
 * 4.super调用构造器
 * 		4.1 可以在字类构造器中显式的使用”super（形参列表）“的方式，调用父类中声明的指定的构造器
 * 		4.2“super(形参列表）”的使用，必须声明在字类构造器的首行
 * 		4.3 在类的构造器中，针对于”this（形参列表）“或”super（形参列表）“只能二选一，不能同时出现
 * 		4.4 在构造器首行没有显式的声明”this（形参列表）“或”super（形参列表）“，则默认调用的是父类中空参的构造器super（）
 * 		4.5 在类的多个构造器中，至少有一个类的构造器使用了”super（形参列表）“，调用了父类中的构造器
 * 
 */


public class SuperTest {
	public static void main(String[] args) {
		
		Super1 s = new Super1();
		s.show();
		
		s.study();

		
		
		System.out.println("****");
		
		Super1 s1 = new Super1("TOM", 21, "IT");
		System.out.println();
		s1.show();
		

		
	}
}
