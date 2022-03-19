package com.OO.java;

/*
 *  继承性练习:
 *  	定义一个ManKind类，包括
 *  	成员变量int sex和int salary
 *  	方法
 */

public class ManKind {
	
	private int sex;//性别
	private int salary;//薪资
	
	
	public ManKind() {
	}
	public ManKind(int sex, int salary) {
		this.sex = sex;
		this.salary = salary;
	}



	public void manOrWoman() {
		if(sex == 1) {
			System.out.println("man");
		}else if(sex == 0) {
			System.out.println("woman");
		}
	}
	
	public void emloyeed() {
		String jobInfo = (salary == 0)? "no job":"job";
		System.out.println(jobInfo);
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
