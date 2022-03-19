package com.team.service;

/**
 * @Description	表示员工的状态
 * @version
 * @date 2021年10月3日下午2:46:26
 */

//枚举：提供有限个对象
//public class Status {
//
//	private final String NAME;
//	//提供构造器
//	private Status(String name) {
//		this.NAME = name;
//	}
//
//	//单例模式
//	public static final Status FREE = new Status("FREE");//空闲
//	public static final Status BUSY = new Status("BUSY");//已加入开发团队
//	public static final Status VOCATION = new Status("VOCATION");//正在休假
//
//	public String getNAME() {
//		return NAME;
//	}
//
//	//重写toString方法
//	@Override
//	public String toString() {
//		return NAME;
//	}
//
//}


public enum Status{
	FREE,BUSY,VOCATION;
}