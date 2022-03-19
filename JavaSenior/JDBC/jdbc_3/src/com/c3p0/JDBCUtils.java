package com.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	/**
	 * @Description 使用c3p0数据库连接池技术
	 * @dage 2021年11月23日下午7:24:34
	 * @return
	 * @throws SQLException
	 */
	//数据库连接池只需提供一个即可
	static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
	
	public static Connection getConnection1() throws SQLException {
		Connection conn = cpds.getConnection();

		return conn;
	}
}
