package com.transaction;

import java.sql.Connection;

import org.junit.Test;

import com.util.JDBCUtils;

public class ConnectionTest {
	@Test
	public void test() throws Exception{
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn);
	}
}
