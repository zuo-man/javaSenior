package com.test.java;

/*
 * 	单例设计模式
 * 	1.所谓类的单例设计模式，就是采取一定的方法保证在整个软件系统中，对某个类只能存在一个对象实例
 * 
 * 	2.饿汉式：对象加载时间过长，但线程安全
 *  	
 * 	3.懒汉式：延迟对象的创建，但线程不安全
 */

public class SingletonTest {
	public static void main(String[] args) {
		
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance();
		
		System.out.println(bank1 == bank2);
	}
}


//饿汉式实现
class Bank{
	
	//1.私有化的构造器
	private Bank() {
		
	}
	
	//2.内部创建类的对象
	//4.要求此对象也必须声明为静态的
	private static Bank instance = new Bank();
	
	//3.提供公共的静态方法，返回类的对象
	public static Bank getInstance() {
		return instance;
	}
	
	//简洁版，不用提供方法，用final
//	public static final Bank instance = new Bank();

}

