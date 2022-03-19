package com.test.bank;

public class Customer {
	
	private String firstName;
	private String lastName;
	private Account accout;
	
	public Customer(String f,String l) {
		this.firstName=f;
		this.lastName=l;
	}

	public Account getAccout() {
		return accout;
	}

	public void setAccout(Account accout) {
		this.accout = accout;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	
	

}
