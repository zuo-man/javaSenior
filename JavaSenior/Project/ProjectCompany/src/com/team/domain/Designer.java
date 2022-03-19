package com.team.domain;
//员工父类3
//设计师

public class Designer extends Programmer{
	private double bonus;//奖金

	public Designer() {
		super();
	}
	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	//重写toString方法
	@Override
	public String toString() {
		//因为不能super父类的父类，所以Employee重写toString时放在方法里中
		return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
	
	public String getDetailsForTeam() {
		return getTeamBaseDatails() + "\t设计师\t" + getBonus();
	}

	

}
