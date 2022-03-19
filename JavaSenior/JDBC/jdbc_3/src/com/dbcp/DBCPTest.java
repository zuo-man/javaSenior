package com.dbcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DBCPTest {
	//方式一：
	@Test
	public void testGetConnection() throws SQLException{
		//创建DBCP的数据库连接池
		BasicDataSource source = new BasicDataSource();
		
		//设置基本信息
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8");
		source.setUsername("root");
		source.setPassword("root");
		
		//设置其他涉及数据库连接池管理的相关属性
		source.setInitialSize(10);
		source.setMaxActive(10);
		//.......
		
		Connection conn = source.getConnection();
		System.out.println(conn);
	}
	
	//方式二：使用配置文件

	//创建一个DBCP数据库连接池
	private static DataSource source;
	static {
		try {
			Properties pros = new Properties();
			FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
			
			pros.load(is);
			DataSource source = BasicDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test	
	public void testGetConnection1() throws Exception{	
		Connection conn = source.getConnection();
		
		System.out.println(conn);
	}
}



