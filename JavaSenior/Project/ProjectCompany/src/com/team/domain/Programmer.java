package com.team.domain;
//员工父类2
//程序员

import com.team.service.Status;

public class Programmer extends Employee{
	private int memberId;//开发团队中的id
	private Status status = Status.FREE;
	private Equipment equipment;
	
	//构造器
	public Programmer() {
		super();
	}	
	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	//getset方法
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEqipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	//重写程序员的toString方法，否则输出的是地址值
	@Override
	public String toString() {
		return getDetails() + "\t程序员\t" + status + "\t\t\t" +equipment.getDescription();
		//是employee的直接子类，也可以如下写法：
//		return super.toString() + "\t程序员\t" + status + "\t\t\t" +equipment.getDescription();
	}
	
	public String getTeamBaseDatails() {
		return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
	}
	
	public String getDetailsForTeam() {
		return getTeamBaseDatails() + "\t程序员";
	}

}
