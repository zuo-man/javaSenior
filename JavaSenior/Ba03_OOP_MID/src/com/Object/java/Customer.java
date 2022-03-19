package com.Object.java;

public class Customer {

	private String name;
	private int age;
	
	public Customer() {
		super();
	} 
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	//重写equals
	//重写：比较两个对象的实体内容（即：
	//手写equals方法：
//	@Override
//	public boolean equals(Object obj) {
//		//如果地址相同，则实体内容肯定也相同
//		if(this == obj) {
//			return true;
//		}
//		//判断obj是否为Customer的实例
//		if(obj instanceof Customer) {
//			Customer cust = (Customer)obj;
//			//比较实体内容是否相同
//			return this.age == cust.age && this.name.equals(cust.name);
//		}else {
//			return false;
//		}
//	}
	//自动生成equals方法：
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	//重写ToString 方法：输出其实际内容
	//手写	
//	@Override
//	public String toString() {
//		return name + age;
//	}
	
	//自动生成ToString
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
	
	
}
