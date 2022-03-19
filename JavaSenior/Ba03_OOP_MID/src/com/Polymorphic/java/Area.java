package com.Polymorphic.java;

public class Area extends AreaMianji {
	
	private double radius;

	public Area(double radius, String color, double weight) {
		super(color, weight);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	//圆面积方法
	public double findArea() {
		return Math.PI * radius * radius;
	}
	
}
