package com.test.java;

public class AccountTest {
	public static void main(String[] args) {
		
		Account acct1 = new Account();
		Account acct2 = new Account("123456",1000);
		
		Account.setInterstTate(0.012);
		Account.setMinMoney(100);
		
		System.out.println(acct1);
		System.out.println(acct2);
		
		System.out.println(acct1.getInterstTate());
		System.out.println(acct1.getMinMoney());
		
	}
}
