package com.team.domain;
//员工父类1
//员工

public class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;//工资


	//构造器
	public Employee() {
		super();
	}
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee(Integer id) {
	}

	public Employee(Integer integer, String s) {
	}

	//getset方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


	//编写方法，以便子类调用super.toString()
	public String getDetails() {
		return id + "\t" + name + "\t" + age + "\t" + salary;
	}

	//重写员工的toString方法，否则遍历信息时输出的是地址值
	@Override
	public String toString() {
		return getDetails();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Employee employee = (Employee) o;

		if (id != employee.id) return false;
		if (age != employee.age) return false;
		if (Double.compare(employee.salary, salary) != 0) return false;
		return name != null ? name.equals(employee.name) : employee.name == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + age;
		temp = Double.doubleToLongBits(salary);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
