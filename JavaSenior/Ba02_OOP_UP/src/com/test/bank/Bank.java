package com.test.bank;

public class Bank {

	private Customer[] customers;//存放多个客户的数据
	private int numverOfCustomers;//记录客户的个数
	
	public Bank() {
		customers = new Customer[10];
	}
	
	//添加客户
	public void addCustomer(String f,String l) {
		Customer cust = new Customer(f,l);
		customers[numverOfCustomers] = cust;
		numverOfCustomers++;
	}
	
	//获取客户的个数
	public int getNumOfCustomers() {
		return numverOfCustomers;
	}
	
	//获取指定位置上的客户
	public Customer getCustomer(int index) {
		//return customers[index]
		if(index >= 0 && index < numverOfCustomers) {
			return customers[index];
		}
		return null;
	}
	
}
