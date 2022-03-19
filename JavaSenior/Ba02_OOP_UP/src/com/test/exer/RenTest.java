package com.test.exer;

/*
 *	在RenTest类中实例化Person类的对象b，调用setAge（）和getAge（）方法
 *	体会Java封装性
 * 
 */

public class RenTest {
	
	public static void main(String[] args) {
		
		Ren p1 = new Ren();
//		p1.age() = 1;//编译不通过

		p1.setAge(12);
		System.out.println("年龄为："+ p1.getAge());
		
		Ren p2 = new Ren("TOM",14);
		p2.setName("ss");
		System.out.println("姓名：" + p2.getName() +"  年龄：" + p2.getAge());
	}
}
