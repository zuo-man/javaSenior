package com.team.domain;

//打印机，实现接口Equipment
public class Printer implements Equipment{
	
	private String name;//机器型号
	private String type;//机器类型
	
	//重写接口Equipment的方法
	@Override
	public String getDescription() {
		return name + "(" + type + ")";
	}

	//构造器
	public Printer() {
		super();
	}
	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	//getset方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
		
	
	

}
