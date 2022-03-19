package com.Polymorphic.java;

public abstract class AreaMianji {
	
	protected String color;
	protected double weight;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public AreaMianji(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	
	//不确定子类构造哪种几何图形，抽象化方法
	public abstract double findArea();
	
}
