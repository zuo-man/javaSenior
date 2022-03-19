package com.test.exer;

public class Person {
	
	String name;
	int age;
	
	/**
	 * sex:1男
	 * sex:2女
	 */
	int sex;
	
	public void study() {//study输出字符串
		System.out.println("studying");
	}

	public void showAge() {
		System.out.println("age" + age);
	}
	
	public int addAge(int i) {//addAge 增加2岁
		age +=i;	
		return age;
	}
	
	
	
}
