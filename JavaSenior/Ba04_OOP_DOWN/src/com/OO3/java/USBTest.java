package com.OO3.java;

/*
 * 	接口的使用
 * 	1.接口满足多态性
 * 	2.接口：实际上就是定义了一种规范
 * 	3.开发中，体会面向接口编程
 * 
 */

public class USBTest {
	public static void main(String[] args) {
		
		Computer com = new Computer();
		//1.创建了接口的非匿名实现类的非匿名对象
		Flash falsh = new Flash();
		com.transferDate(falsh);//本身接口不能造对象，不能传值usb，只能造实现类的对象，体现了多态性
		
		//2.创建了接口的非匿名实现类的匿名对象
		com.transferDate(new Printer());
		
		//3.创建了接口的匿名实现类的非匿名对象
		USB phone = new USB() {
			@Override
			public void start() {
				System.out.println("手机开机");
			}
			@Override
			public void stop() {
				System.out.println("手机关机");
			}	
		};
		com.transferDate(phone);
		
		//4.创建了接口的匿名实现类的匿名对象
		com.transferDate(new USB() {
			@Override
			public void start() {
				System.out.println("xx开机");
			}
			@Override
			public void stop() {
				System.out.println("xx开机");
			}	
		});
		
		
	}
}

class Computer{
	
	public void transferDate(USB usb) {//USB usb = new Flash();声明的是usb，new的是实现类的对象
		usb.start();
		
		System.out.println("干活");
		
		usb.stop();
	}
	
}


//接口
interface USB{
	//常量：定义了长、宽、高等数值
	
	void start();
	
	void stop();
}

class Flash implements USB{

	@Override
	public void start() {
		System.out.println("U盘开启工作");
	}
	@Override
	public void stop() {
		System.out.println("U盘结束工作");
	}	
}

class Printer implements USB{

	@Override
	public void start() {
		System.out.println("打印机开启工作");
	}
	@Override
	public void stop() {
		System.out.println("打印机结束工作");
	}
	
}




