package com.test.java;

/*
 * 	编写一个类实现银行账户的概念，包含属性有：账号、密码、存款余额、利率、最小余额
 * 
 * 	编写主类，使用银行账户类。输入、输出3个储户的上述信息
 */

public class Account {

	private int id;
	private String passward = "123";//密码
	private double balance;//存款余额
	
	private static double interstTate;//利率
	private static double minMoney = 1.0;//最小余额
	
	private static int init  = 1001;//自动生成id
	
	
	//构造器
	public Account() {
		id = init++;
	}
	public Account(String passward,double balance) {
		this();
		this.passward = passward;
		this.balance = balance;
	}

	//getset方法，其中id的set方法可以不加，init的getset方法不加，存款余额的set方法可以不加
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public static double getInterstTate() {
		return interstTate;
	}
	public static void setInterstTate(double interstTate) {
		Account.interstTate = interstTate;
	}
	public static double getMinMoney() {
		return minMoney;
	}
	public static void setMinMoney(double minMoney) {
		Account.minMoney = minMoney;
	}
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", passward=" + passward + ", balance=" + balance + "]";
	}
	
	
	
}
