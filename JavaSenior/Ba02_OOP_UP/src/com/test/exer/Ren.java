package com.test.exer;

/*
 *1.创建程序，在其中定义两个类：Ren和RenTest类。定义如下：
 *	用setAge（）设置人的合法年龄（0~100），用getAge（）返回人的年龄
 *
 *2.练习2
 *	2.1 在前面 定义的Person类中添加构造器，利用构造器设置所有人的age属性
 *		初始化值都为18.
 *	2.2 修改上题中类和构造器，增加name属性，使得每次创建Person对象的同时
 *		初始化对象的age属性值和name属性值
 * 
 */


public class Ren{
	
	private int age;
	private String name;
	
	//构造器
	public Ren() {
		age = 18;
	}
	public Ren(String n,int a) {
		name = n;
		age = a;
	}
	
	public void setAge(int a) {
		if(a <0 || a > 100) {
			//throw new RuntimeException("传入的数据非法！");
			System.out.println("传入的数据非法！");
			return;//结束方法，就不用写else
		}
		age = a;
	}
	
	//封装性
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}


