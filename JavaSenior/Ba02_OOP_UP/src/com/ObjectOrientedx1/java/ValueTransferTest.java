
package com.ObjectOrientedx1.java;

/*
 * 关于变量的赋值：
 * 		如果变量是基本数据类型，此时赋值的是变量所保存的数据值
 * 		如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值
 * 
 * 属性赋值先后顺序：
 * 	①默认初始胡
 * 	②显式初始化
 * 	③构造器初始化
 * 
 *  ④通过”对象.方法“ 或”对象.属性“的方式，赋值
 * 
 * 
 */


public class ValueTransferTest {

	public static void main(String[] args) {
		
		System.out.println("基本数据类型");
		int m = 10;
		int n = m;
		
		System.out.println("m=" +m +"   " +"n="+n);
		
		n=20;
		
		System.out.println("m=" +m +"   " +"n="+n);
	
		System.out.println("引用数据类型");
		
		Order o1 = new Order();
		o1.orderId = 1001;
		
		Order o2 = o1;
		
		System.out.println("o1.orderId="+o1.orderId + ",o2.orderId = "+o2.orderId);
		
		o2.orderId = 1002;
		
		System.out.println("o1.orderId="+o1.orderId + ",o2.orderId = "+o2.orderId);
	}
	
}
class Order{
	int orderId;
 }
