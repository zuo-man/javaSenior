package com.OO3.java;

/*
 * 	代理模式的举例：明星
 * 		举例一个明星，唱歌他自己唱，但是其他工作经纪人做
 */

public class NetWorkTest2 {
	public static void main(String[] args) {
		//调用方式一：
		Star s = new Proxy(new Starxing());
		s.confer();
		s.signContract();
		s.sing();
		s.money();	
		
		//调用方式二：
		Starxing w = new Starxing();
		Proxy p = new Proxy(w);
		p.confer();
		p.signContract();
		p.sing();
		p.money();
	}
}

//接口,定义一个明星该干什么的规范
interface Star {
	void confer();//面谈
	
	void signContract();//签合同
	
	void sing();//唱歌
	
	void money();//收钱
}

//被代理类,明星
class Starxing	implements Star{

	public void confer() {
	}
	public void signContract() {
	}
	public void sing() {
		System.out.println("哇啊啊啊啊啊啊啊啊~~~~~~");
	}
	public void money() {
	}
}

//代理类,经纪人
class Proxy implements Star{
	private Star real;//接口的声明
	
	//通过构造器对real属性初始化
	public Proxy(Star real) {
		this.real = real;
	}

	public void confer() {
		System.out.println("经纪人面谈");
	}
	public void signContract() {
		System.out.println("经纪人签合同");
	}
	
	public void sing() {
		real.sing();//调用非代理类：明星唱歌
	}
	
	public void money() {
		System.out.println("经纪人收钱");
	}
}

