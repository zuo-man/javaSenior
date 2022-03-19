package com.test.java;

/*
 * 	单例设计模式
 * 	1.所谓类的单例设计模式，就是采取一定的方法保证在整个软件系统中，对某个类只能存在一个对象实例
 * 
 */

public class SingletonTest2 {
	public static void main(String[] args) {
		
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance();
		
		System.out.println(bank1 == bank2);
	}
}


class Bank2{
	
	//1.私有化的构造器
	private Bank2() {
		
	}
	
	//2.内部创建类的对象
	//4.要求此对象也必须声明为静态的
	private static Bank2 instance = null;
	
	//3.提供公共的静态方法，返回类的对象
	public static Bank2 getInstance() {
		if(instance == null) {
			instance = new Bank2();
		}
		return instance;
	}
	
}
