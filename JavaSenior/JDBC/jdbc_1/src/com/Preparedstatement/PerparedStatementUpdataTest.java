package com.Preparedstatement;

import java.io.InputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.junit.Test;

import com.connection.ConnectionTest;
import com.util.JDBCUtils;
/*
 * 使用PerparedStatement来替换Statement，实现对数据表的增删改查操作
 * 
 * 增删改、查
 */

public class PerparedStatementUpdataTest {
	//通用的增删改操作									//用try-catch
	public int update(String sql,Object ...args) throws Exception{//sql中占位符的个数与可变形参的长度相同
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.获取数据库的连接
			conn = JDBCUtils.getConnection();
			
			//2.预编译sql语句，返回PerparedStatement的实例
			ps = conn.prepareStatement(sql);
			//3.填充占位符
			for(int i = 0;i < args.length;i++) {
				ps.setObject(i + 1, args[i]);//数组从0开始
			}
			
			//4.执行
			/*
			 * ps.execut():
			 * 执行是查询操作，有返回结果，则此方法返回true
			 * 执行是增删改操作，没有返回结果，则此方法返回false
			 */
			//方式一：
//			ps.execute();
			//方式二：
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.资源关闭
			JDBCUtils.closeResource(conn, ps);
		}
		return 0;
	}
	
	
	
	
	//修改customers表的一条记录
	@Test
	public void testUpdate() {//用try-catch
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.获取数据库的连接
			conn = JDBCUtils.getConnection();
			//2.预编译sql语句，返回PerparedStatement的实例
			String sql = "update customers set name = ? where id = ?";
			ps = conn.prepareStatement(sql);
			//3.填充占位符
			ps.setObject(1, "无暇");
			ps.setObject(2, 18);
			//4.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.资源关闭
			JDBCUtils.closeResource(conn, ps);
		}
	}
	
	
	// 想customers表中添加一条记录
	@Test
	public void testInsert() throws Exception {//用try-catch
		// 1.读取配置文件中的4个基本信息：用类的加载器加载
		InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

		Properties p = new Properties();
		p.load(is);

		String user = p.getProperty("user");
		String password = p.getProperty("password");
		String url = p.getProperty("url");
		String driverClass = p.getProperty("driverClass");

		// 2.加载驱动
		Class.forName(driverClass);

		// 3.获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
//		System.out.println(conn);
		
		//4.预编译sql语句，返回PreparedStatement的实例
		String sql = "insert into customers(name,email,birth)values(?,?,?)";//?占位符
		PreparedStatement ps = conn.prepareStatement(sql);
		//5.填充占位符
		ps.setString(1,"小优");
		ps.setString(2,"123@");
		//用日期类
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = time.parse("2000-02-23");
		ps.setDate(3, new java.sql.Date(date.getTime()));
		
		//6.执行操作
		ps.execute();
		
		//7.关闭资源
		ps.close();
		conn.close();
	}
}
