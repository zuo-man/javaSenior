package com.transaction;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.util.JDBCUtils;

/*
 * 1.什么叫数据库事务？
 *	事务：一组逻辑操作单元，使数据从一种状态变换到另一种状态。
 *		 > 一组逻辑操作单元；一个或多个DML操作。
 *
 *	2.事务处理的原则：保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
 *	当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改就永久地保存
 *	下来；要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。
 *
 *	3.数据一旦提交，就不可回滚
 *	
 *	4.哪些操作会导致数据的自动提交？
 *		>DDL操作一旦执行，都会自动提交
 *			>set antocommit = false 对DDL操作失效
 *  	>DML默认情况下，一旦执行，就会自动提交
 *  		>可以通过set antocommit = false 方式取消DML操作的自动提交
 *  	>默认在关闭连接时，会自动提交数据
 */
public class TransactionTest {
	@Test
	public void testUpdateWith() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();

			// 1.取消数据的自动提交
			conn.setAutoCommit(false);

			String sql = "update user_table set balance = balance -100 where user = ?";
			update(conn, sql, "AA");

			// 模拟网络异常
			System.out.println(10 / 0);

			String sql2 = "update user_table set balance = balance + 100 where user = ?";
			update(conn, sql2, "BB");

			System.out.println("转账成功");

			// 2.提交数据
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			// 3.回滚数据
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 通用的增删改操作 ----考虑上事务
	public int update(Connection conn, String sql, Object... args) {// sql中占位符的个数与可变形参的长度相同

		PreparedStatement ps = null;
		try {
			// 1.获取数据库的连接

			// 2.预编译sql语句，返回PerparedStatement的实例
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);// 数组从0开始
			}
			// 4.执行
			// ps.execut(): 执行是查询操作，有返回结果，则此方法返回true 执行是增删改操作，没有返回结果，则此方法返回false
			// 方式一：
//				ps.execute();
			// 方式二：
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 数据连接池需要操作，修改自动提交数据
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// 5.资源关闭
			JDBCUtils.closeResource(null, ps);
		}
		return 0;
	}

	//**************************************************************
	
	@Test
	public void testTransactionSelect() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		
		//获取当前连接的隔离级别
		System.out.println(conn.getTransactionIsolation());
		
		//设置数据库的隔离级别
//		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		
		String sql = "select user,password,balance from user_table where user = ?";
		User user = getInstance(conn, User.class, sql, "CC");

		System.out.println(user);
	}

	@Test
	public void testTransactionUpdate() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "update user_table set balance = ? where user = ?";
		update(conn, sql, 5555, "CC");
		System.out.println("修改成功");
	}

	// 通用的查询操作，用于返回数据表中的一条数据2.0，考虑上事务
	// <T>泛型方法叫T
	public <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object... args) {
		// 1.获取数据库的连接

		PreparedStatement ps = null;
		ResultSet result = null;
		try {

			// 2.预编译sql语句，返回PerparedStatement的实例
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			result = ps.executeQuery();
			// 获取结果集的元数据
			ResultSetMetaData re = result.getMetaData();
			// 通过ResultSetMetaData获取结果集中的列数
			int colum = re.getColumnCount();

			if (result.next()) {
				T t = clazz.getDeclaredConstructor().newInstance();// 创建泛型T对象，准备赋值

				// 处理结果集一行数据中的每一个列
				for (int i = 0; i < colum; i++) {
					// 获取列值
					Object columValue = result.getObject(i + 1);

					// 获取每个列列名
//							String columnName = re.getColumnName(i + 1);
					String columnLabel = re.getColumnLabel(i + 1);

					// 给t对象指定的columnName属性，赋值为columValue：通过反射
					Field f = clazz.getDeclaredField(columnLabel);
					f.setAccessible(true);
					f.set(t, columValue);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps, result);
		}
		return null;
	}
}
