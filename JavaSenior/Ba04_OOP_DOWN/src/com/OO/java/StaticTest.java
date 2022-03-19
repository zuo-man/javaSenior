package com.OO.java;

/*
 * static关键字使用
 * 
 * 1.static：静态
 * 2.static：可用来修饰：属性、方法、代码块、内部类
 * 
 * 3.使用static修饰属性：静态变量
 * 		3.1属性，按是否使用static修饰，又分为：静态属性               非静态属性（实例变量）
 * 		实例变量：创建类的多个对象，每个对象都独立的拥有一套类中的非静态属性。当修改其中一个对象的
 * 				非静态属性时，不会导致其他对象中同样的属性值的修改
 * 		静态变量：创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，
 * 				会导致其他对象调用此静态变量时，已修改
 * 		3.2 static修饰属性的其他说明：
 * 			①静态变量随着类的加载而加载。可以通过“类 . 静态变量”的方式进行调用
 * 			②静态变量的加载要早于对象的创建
 * 			③由于类只会加载一次，则静态变量在内存中也只会存在一份：存在方法区的静态域中
 *
 * 			④	   类变量	实例变量
 * 			类	   y	  n
 * 			对象	   y      y
 * 		3.3 静态属性举例：System.out;	Math.PI；
 * 
 * 4.使用static修饰方法：静态方法
 * 			①随着类的加载而加载，可以通过“类 . 静态方法”的方式进行调用
 * 			②	   	静态方法	非静态方法
 * 				类	   y	  n
 * 				对象	   y      y
 * 			③ 静态方法中，只能调用静态的方法或属性
 * 			     非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
 * 5.在静态的方法内，不能使用this关键字、super关键字kk
 * 
 * 6.确定一个属性是否要声明为static
 * 		>属性是可以被多个对象共享的，不会随着对象的不同而不同
 * 		>类中的常量也常常声明为static
 * 
 * 	  确定一个方法是否要声明为static
 * 		>操作静态属性的方法，通常设置为static
 * 		>工具类中的方法，习惯上声明为static。
 */

public class StaticTest {
	public static void main(String[] args) {
		
		Chinese.nation = "中国";
		
		Chinese c1 = new Chinese();
		c1.name = "小何";
		c1.age = 21;
		c1.nation = "CHN";
		
		Chinese c2 = new Chinese();
		c2.name = "小优";
		c2.age = 22;
		c2.nation = "CHINA";
		
		System.out.println(c1.nation);
			
		
		//编译不通过,不能调用非静态属性
//		Chinese.name = "xx";kkkkk
		
		c1.eat();
		
		Chinese.show();
		
		//不能使用类来调用非静态方法
//		Chinese.eat();
			
	}
}

//中国人
class Chinese{
	
	String name;
	int age;
	static String nation;
	
	public void eat() {
		System.out.println("吃饭");
		//调用非静态结构
		System.out.println(name);
		//调用静态结构
		System.out.println(nation);
	}
	
	public static void show() {
		System.out.println("我是中国人");
//		eat();静态方法中不能调用非静态方法
//		name = "TOM";静态方法中不能调用非静态属性
		//可以调用静态的结构
		System.out.println(Chinese.nation);
		walk();
	}
	
	
	public static void walk() {
		
	}
}
