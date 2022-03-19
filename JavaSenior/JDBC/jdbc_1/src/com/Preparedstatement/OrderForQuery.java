package com.Preparedstatement;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.util.JDBCUtils;

/**
 * @Description 针对于Order表的通用查询操作
 * @version
 * @date 2021年11月19日下午4:09:14
 */
public class OrderForQuery {
	/*
	 * 针对于表的字段名于类的属性名不相同的情况
	 * 1.必须声明sql时，使用类的属性名来命名字段的别名
	 * 2.使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),获取列的别名
	 * 3.如果sql中没有给字段起别名，getColumnLabel()获取的就是别名
	 */
	//针对于Order表通用的查询操作
	  //Order:就返回Order对象
	public Order orderForQuery(String sql,Object...args) throws Exception{//用try-catch
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i = 0;i < args.length;i++) {
			ps.setObject(i + 1, args[i]);
		}
		
		//执行，获取结果集
		ResultSet result = ps.executeQuery();
		//获取结果集的元数据
		ResultSetMetaData re = result.getMetaData();
		//获取列数
		int colum = re.getColumnCount();
		if(result.next()) {
			Order order = new Order();
			for(int i = 0;i < colum;i++) {
				//获取每个列的列值：通过ResultSet
				Object columnValue = result.getObject(i + 1);
				//通过ResultSetMetaData
				//获取列的列名：getColumnName():不推荐使用
				//获取列的别名：getColumnLabel()
//				String columnName = re.getColumnName(i + 1);
				String columnLabel = re.getColumnLabel(i + 1);
				
				//通过反射，将对象指定名columnName的属性赋值为指定的值columnValue
				Field f = Order.class.getDeclaredField(columnLabel);
				f.setAccessible(true);
				f.set(order, columnValue);
			}
			return order;
		}
		
		JDBCUtils.closeResource(conn, ps, result);
		return null;
	}
	
	
	
	
	@Test
	public void test(){//用try-catch
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);
			
			result = ps.executeQuery();
			if(result.next()) {
				int id = (int) result.getObject(1);
				String name = (String) result.getObject(2);
				Date date = (Date) result.getObject(3);
				
				Order order = new Order(id, name, date);
				System.out.println(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, ps, result);
		}	
	}
}
