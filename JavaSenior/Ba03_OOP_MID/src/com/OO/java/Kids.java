package com.OO.java;

/*
 * 定义Kids继承ManKind，并包括成员变量int yearOld，方法prinAge（）
 */

public class Kids extends ManKind{

	private int yearsOld;
	
	public void prinAge() {
		System.out.println("I am "+ yearsOld + "years old.");
	}
		

	
	public Kids() {
	}
	public Kids(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	
}
