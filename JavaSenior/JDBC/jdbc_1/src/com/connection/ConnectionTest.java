package com.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;


public class ConnectionTest {
	//将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文集那的方式，获取连接
	@Test
	public void test() throws Exception {
		//1.读取配置文件中的4个基本信息：用类的加载器加载
		InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties p = new Properties();
		p.load(is);
		
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		String url = p.getProperty("url");
		String driverClass = p.getProperty("driverClass");
		
		//2.加载驱动
		Class.forName(driverClass);
		
		//3.获取连接
		Connection conn = DriverManager.getConnection(url,user,password);
		System.out.println(conn);
	}
	
	
	
	
	
	@Test
	public void test1() throws SQLException {
		// 获取Driver实现类对象
		Driver driver = new com.mysql.cj.jdbc.Driver();

		// url:http://localhost:8080/gmall/keyboard.jpg
		// jdbc:mysql：协议
		// localhost:ip地址
		// 3306：默认mysql的端口号
		// test:test数据库
		// 将用户名和密码封装在Properties中
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8";
		Properties info = new Properties();

		info.setProperty("user", "root");
		info.setProperty("password", "root");

		Connection conn = driver.connect(url, info);

		System.out.println(conn);
	}

	// 方式二：对方式一的迭代：在如下的程序中不出现第三方的API，使得程序具有更好的可移植性
	@Test
	public void test2() throws Exception {
		// 1.获取Driver实现类对象，使用反射
		Class c1 = Class.forName("com.mysql.cj.jdbc.Driver");
		Driver d1 = (Driver) c1.newInstance();

		// 2.提供要连接的数据库
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8";

		// 3.提供连接需要的用户名密码
		Properties info = new Properties();

		info.setProperty("user", "root");
		info.setProperty("password", "root");

		// 4.获取连接
		Connection conn = d1.connect(url, info);
		System.out.println(conn);
	}

	// 方式三：使用DriverManager替换Driver
	@Test
	public void test3() throws Exception {
		// 1.获取Driver实现类对象，使用反射
		Class c1 = Class.forName("com.mysql.cj.jdbc.Driver");
		Driver d1 = (Driver) c1.newInstance();

		// 2.提供另外三个连接的基本信息
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "root";

		// 注册驱动
		DriverManager.registerDriver(d1);

		// 获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
	}

	// 方式四
	@Test
	public void test4() throws Exception {
		// 1.提供另外三个连接的基本信息
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "root";
		
		// 2.加载Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//相较于方式三：可以省略如下的操作，在mysqlDriver实现类中，声明了注册驱动的静态代码块
//		Driver d1 = (Driver) c1.newInstance();
//		// 注册驱动
//		DriverManager.registerDriver(d1);

		// 获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
	}
}
