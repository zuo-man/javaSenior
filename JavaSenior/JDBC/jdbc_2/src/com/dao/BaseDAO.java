package com.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.JDBCUtils;

/*
 * DAO:data(base) access object
 * 封装了针对于数据表的通用操作
 */
public abstract class BaseDAO {
	// 通用的增删改操作 ----考虑上事务
	public int update(Connection conn, String sql, Object... args) {// sql中占位符的个数与可变形参的长度相同
		PreparedStatement ps = null;
		try {
			// 1.获取数据库的连接：传过来的形参conn

			// 2.预编译sql语句，返回PerparedStatement的实例
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);// 数组从0开始
			}
			// 4.执行
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.资源关闭
			JDBCUtils.closeResource(null, ps);
		}
		return 0;
	}

	// 通用的查询操作，用于返回数据表中的一条数据2.0，考虑上事务
	// <T>泛型方法叫T
	public <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			// 1.获取数据库的连接：传过来的形参conn

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
//					String columnName = re.getColumnName(i + 1);
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

	//实现针对于不用表的通用的查询操作，返回数据表中的多条记录构成的集合 2.0，使用事务
	public <T> List<T> getForList(Connection conn, Class<T> clazz, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			// 1.获取数据库的连接：传过来的形参conn
			
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

			// 创建集合对象
			ArrayList<T> list = new ArrayList<T>();
			while (result.next()) {
				T t = clazz.getDeclaredConstructor().newInstance();// 创建泛型T对象，准备赋值

				// 处理结果集一行数据中的每一个列:给t对象指定的属性赋值
				for (int i = 0; i < colum; i++) {
					// 获取列值
					Object columValue = result.getObject(i + 1);

					// 获取每个列列名
//					String columnName = re.getColumnName(i + 1);
					String columnLabel = re.getColumnLabel(i + 1);

					// 给t对象指定的columnName属性，赋值为columValue：通过反射
					Field f = clazz.getDeclaredField(columnLabel);
					f.setAccessible(true);
					f.set(t, columValue);
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps, result);
		}
		return null;
	}
	
	//用于查询特殊值的通用方法
	public <E> E getValue(Connection conn, String sql, Object...args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0;i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			rs = ps.executeQuery();
			if(rs.next()) {
				return (E) rs.getObject(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(null, ps, rs);
		}
		return null;
	}
	
	
	
	
	//DBUtils实现CRUD操作
	/*
	 * 通用增删改操作
	 */
//	public int updateD(Connection conn,String sql, Object... params) {
//		int count = 0;
//		try {
//			count = queryRunner.update(conn, sql, params);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return count;
//	}
	/*
	 * 获取一个对象
	 */
//	public T getBean(Connection conn, String sql, Object... params) {
//		T t = null;
//		try {
//			t = queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return t;
//	}
}





