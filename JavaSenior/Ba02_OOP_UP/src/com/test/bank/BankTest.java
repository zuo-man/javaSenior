package com.test.bank;

public class BankTest {

	public static void main(String[] args) {
		
		Bank bank = new Bank();
		bank.addCustomer("jane", "Smith");
		
		//连续操作
		bank.getCustomer(0).setAccout(new Account(2999));
		
		bank.getCustomer(0).getAccout().withdraw(300);
		
		double balance = bank.getCustomer(0).getAccout().getBalance();
		System.out.println("客户：" + bank.getCustomer(0).getFirstName() + "的账户余额为："+balance);
		
		
		System.out.println("******");

		bank.addCustomer("禾","小");
		System.out.println("银行客户的个数为：" + bank.getNumOfCustomers());
		
		
		
	}
	
}
