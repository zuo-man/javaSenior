package com.PreparedStatement2;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.util.JDBCUtils;

/*
 * 使用PreparedStatement实现批量数据的操作
 * 
 * 题目：向goods表中插入1000条数据
 * create table goods(
	id int primary key auto_increment,
	name varchar(20) );
	
 */
public class InsertTest {
	//一：Statement:不建议用
	//批量插入的方式二：使用PreparedStatement
	@Test
	public void testInsert1(){//try-catch
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into goods(name)values(?)";
			ps = conn.prepareStatement(sql);
			for(int i = 1; i  <= 1000; i++) {
				ps.setObject(1, "name_" + i);
				
				ps.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, ps);
		}
	}
	
	/*
	 * 批量插入的方式三：
	 * 1.addBatch()、executeBatch()、clearBatch()
	 * 2.mysql服务器默认是关闭批处理，需要通过一个参数，让mysql开启批处理
	 * 在配置文件url后面加参数
	 * 3.使用更新的mysql驱动
	 */
	@Test
	public void testInser2() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into goods(name)values(?)";
			ps = conn.prepareStatement(sql);
			for(int i = 1; i  <= 1000; i++) {
				ps.setObject(1, "name_" + i);
				
				//1.攒 sql
				ps.addBatch();
				
				if(i % 100 == 0 ) {
					//2.执行batch
					ps.executeBatch();
					
					//3.清空batch
					ps.clearBatch();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, ps);
		}
	}
	
	//批量插入的方式四
	@Test
	public void testInser3() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			
			//设置不允许自动提交数据
			conn.setAutoCommit(false);
			
			String sql = "insert into goods(name)values(?)";
			ps = conn.prepareStatement(sql);
			for(int i = 1; i  <= 1000; i++) {
				ps.setObject(1, "name_" + i);
				
				//1.攒 sql
				ps.addBatch();
				
				if(i % 100 == 0 ) {
					//2.执行batch
					ps.executeBatch();
					
					//3.清空batch
					ps.clearBatch();
				}
			}
			
			//提交数据
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, ps);
		}
	}
}



