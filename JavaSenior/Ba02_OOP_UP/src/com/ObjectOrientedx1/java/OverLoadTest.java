 
package com.ObjectOrientedx1.java;

/*
 * 方法的重载（overload）
 * 
 * 	1，定义：在同一个类中k允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可
 * 		
 * 		两同一不同：同一个类、相同方法名
 * 				参数列表不同：参数个数不同，参数类型不同
 * 		
 * 		方法名--->参数列表c
 * 
 * 	2.判断是否重载：
 * 		和方法的权限修饰符、返回类型值、形参变量名、方法体无关
 * 
 */


public class OverLoadTest {
	
	public static void main(String[] args) {
		
		OverLoadTest test = new OverLoadTest();
		test.getSum("1",1);
		
	}
	
	
	
	//如下的4个方法构成了重载
	public void getSum(int i , int j) {
		System.out.println("1");
	}
	
	public void getSum(double d1, double d2) {
		System.out.println("2");
	}

	public void getSum(String s ,int i) {
		System.out.println("3");
	}
	
	public void getSum(int i, String s) {
		System.out.println("4");
	}
}
