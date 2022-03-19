package com.Object.java;

/*
 *  == 和equals（）区别
 *  
 *  ==：运算符
 *   1.可以使用在基本数据类型变量和引用数据类型变量中
 *   2.如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等（不一定类型要相同）
 *     如果比较的是引用数据类型变量：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
 *   3. ==符号使用时，必须保证符号左右两边的变量类型一致
 *     
 *  equals()方法的使用：是方法，而非运算符
 *   1.只适用于引用数据类型
 *   2.Object类中equals（）的定义：
 *   	public boolean equals(Object obj) {
        	eturn (this == obj);
    	}
    	说明：Object类中定义的equals（）和==的作用是相同的：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
 *  
 *   3.像String、Date、File、包装类等都重写了Object类中的equals（）方法
 * 	  使得在调用对象equals（）时，返回‘实体信息’
 */

public class EqualsTest {
	public static void main(String[] args) {

		//基本数据类型
		int i =10;
		int j =10;
		double d= 10.0;
		System.out.println(i == j);//true
		System.out.println(i == d);//true
		
//		boolean b = true;
//		System.out.println(i == b);//编译报错
	
		char c =10;
		System.out.println(i == c);//true
		
		char c1 ='A';
		char c2 = 65;
		System.out.println(c1 == c2);//true
		
		//引用类型： 比较的是地址值
		Customer cust1 = new Customer("TOM",21);
		Customer cust2 = new Customer("TOM",21);
		System.out.println(cust1 == cust2);//false
		
		String str1 = new String("xx");
		String str2 = new String("xx");
		System.out.println(str1 == str2);//false
		
		System.out.println("******");
		
		System.out.println(cust1.equals(cust2));//false 重写了equals方法后：true
		System.out.println(str1.equals(str2));//true
		
		
		
	}
}
