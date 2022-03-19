package com.team.domain;
//架构师

public class Architect extends Designer{
	private int stock;//股票

	public Architect() {
		super();
	}
	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//重写toString方法
	@Override
	public String toString() {
		//因为不能super父类的父类，所以Employee重写toString时放在方法里中
		return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
	}
	
	public String getDetailsForTeam() {
		return getTeamBaseDatails() + "\t架构师\t" + getBonus() + "\t" + getStock();
	}
	
	
}
