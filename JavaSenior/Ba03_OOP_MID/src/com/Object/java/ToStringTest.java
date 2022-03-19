package com.Object.java;

import java.sql.Date;

/*
 * Object类中toString()的使用
 * 
 * 1.当输出一个对象的引用时，实际上就是调用当前对象的toString()
 * 
 * 2.Object类中toString（）的定义
 * 		public String toString() {
        	return getClass().getName() + "@" + Integer.toHexString(hashCode());
    	}
 * 
 * 3.像String、Date、File、包装类等都重写了Object类中的toString（）方法
 * 	  使得在调用对象toString（）时，返回‘实体信息’
 */



public class ToStringTest {
	public static void main(String[] args) {
		
		Customer cust1 = new Customer("Tom",21);
		System.out.println(cust1.toString());//调用的是地址值com.Object.java.Customer@15db9742
											//重写toString方法后：Tom21
		System.out.println(cust1);//调用的是地址值com.Object.java.Customer@15db9742. 重写toString方法后：Tom21
		
		String str = new String("xx");
		System.out.println(str);//xx返回实体信息
		
		Date date = new Date(12231);
		System.out.println(date.toString());//返回实体信息
		
	}
}
