
package com.ObjectOriented.java;

import java.util.Arrays;

/*
 * 类中方法的声明和使用
 * 
 * 	方法：描述类应该具有的功能。
 * 	比如：Math类：sqrt（）\random\...
 * 		Scanner类：nextXxx()...
 * 		Arrays类：sort（）\binarySearch()\toString()\equls()\...
 * 
 * 
 * 				无返回值					有返回值
 * 	无形参	void方法名（）{}			返回值的类型方法名（）{}
 * 	有形参	void方法名（形参列表）{}		返回值的类型方法名（形参列表）{}
 * 
 * 
 * 	1.举例
 * 	public void eat() 
 * 	public void sleep(int hour) 
 * 	public String getName()
 * 	public String getNation(String nation)
 * 
 * 
 * 
 * 	2. 方法的声明：权限修饰符	返回值类型	 方法名（形参列表）{
 * 						方法体
 * 						}
 * 		static、final、abstract 来修饰的方法，后面再说
 * 
 * 
 * 	3.说明：
 * 		3.1关于权限修饰符：
 * 			java规定的4种权限修饰符：private、public、缺省、protected
 * 		
 * 		3.2返回值类型：		有返回值		无返回值
 * 			3.2.1如果方法有返回值，则必须在方法声明时，指定返回值的类型。同时，方法中，需要使用
 * 				 return关键字来返回指定类型的变量或常量。：”return 数据“
 * 				  如果方法没有返回值，则方法声明时，使用void来表示
 * 				  通常，没有返回值的方法中，就不使用return。但是，如果使用的话，只能
 * 				  用”return;“表示结束此方法的意思
 * 
 * 		3.3 方法名：属于标识符，遵循标识符的规则和规范
 * 		3.4 形参列表： 方法可以声明0个，1个，或多个形参。
 * 			格式：数据类型1 形参1  ,  数据类型2 形参2, ...
 * 
 * 		
 * 	4.return关键字的使用：
 * 		1.使用范围：使用在方法体中
 * 		2.作用：①结束方法
 * 			  ②针对于有返回值类型的方法，使用”return 数据“方法返回所要的数据。
 * 		3.return关键字后面不可以声明执行语句
 * 		
 * 
 * 	5.方法的使用中，可以调用当前类的属性或方法
 * 		特殊的：方法A中又调用了方法A：递归方法
 * 	  方法中，不可以定义方法	
 * 
 * 
 * 	6.匿名对象的使用
 * 		创建对象时，没有显式的赋给一个变量名。即为匿名对象
 * 		特征：匿名对象只能调用一次
 * 
 * 	7.方法的重载（overload） 
 * 		定义：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可
 * 
 * 	 
 * 
 */



public class CustomerTest {
	
	public static void main(String[] args) {
		
		Customer cust1 = new Customer();
		
		cust1.eat();
	
		cust1.sleep(2);
		
		
		//匿名对象,只调用一次
		new Customer().eat();
		new Customer().sleep(3);
		
		ChiMall chi = new ChiMall();
		//chi.show(cust1);
		//匿名对象的使用
		chi.show(new Customer());
		
		
	}
}

class ChiMall{
	public void show(Customer customer) {
		customer.eat();		
	}
}


//客户类
class Customer{
	
	//属性
	String name;
	int age;
	boolean isMale;
	
	//方法
	public void eat() {
		System.out.println("客户吃饭");
		return;
		//return后不可以声明表达式
		//System.out.println("hello");
	}
	
	public void sleep(int hour) {
		System.out.println("休息了" + hour +"个小时");
	}
	
	public String getName() {
		return name;
		//return "Tom";
	}
	
	public String getNation(String nation) {
		String info = "我的国籍是" + nation;
		return info;
	}
	
}
