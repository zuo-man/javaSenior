package com.OO3.java;

/*
 * 	接口的应用：代理模式
 */

public class NetWorkTest {
	public static void main(String[] args) {
		
		Server ser = new Server();
		ProxyServer proxyServer = new ProxyServer(ser);	
		proxyServer.browse();
		
		//方法二：
		Network xx = new ProxyServer(new Server());
		xx.browse();
		
	}
}

interface Network{

	public void browse();
	
}

//被代理类
class Server implements Network{

	@Override
	public void browse() {
		System.out.println("服务器访问");
	}
	
}

//代理类
class ProxyServer implements Network{
	
	private Network work;
	
	public ProxyServer(Network work) {
		this.work = work;
	}
	
	public void check() {
		System.out.println("检查");
	}

	@Override
	public void browse() {
		check();
		work.browse();//调用被代理类的方法
	}
	
}