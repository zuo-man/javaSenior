package com.test.exer;

public class Girl {

	private String name;
	private int age;
	
	
	public Girl() {
		
	}
	public Girl(String name) {
		
	}
	public Girl(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void marry(Boy boy) {
		System.out.println("我想嫁给" + boy.getName());
		boy.marry(this);//使用this，返回说这句话的女孩
	}
	
	
	/**
	 * 	比较两个对象的大小
	 * 	girl
	 * 	正数：当前对象大； 复数，当前对象小； 0 ，一样大
	 */
	public int compare(Girl girl) {
//		if(this.age > girl.age) {
//			return 1;
//		}else if(this.age < girl.age) {
//			return -1;
//		}else {
//			return 0;
//		}
		
		return this.age - girl.age;
	}
	

}
