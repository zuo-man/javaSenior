package com.PreparedStatement2;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.Preparedstatement.Customer;
import com.Preparedstatement.Order;
import com.util.JDBCUtils;

/**
 * @Description 使用PreparedStatement实现针对于不用表的通用的查询操作，返回数据表中的多条记录构成的集合
 * @version
 * @date 2021年11月19日下午5:20:50
 */
public class PreparedStatementQueryTest2 {
	public <T> List<T> getForList(Class<T> clazz, String sql, Object... args){// 用try-catch
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			//1.获取数据库的连接
			conn = JDBCUtils.getConnection();
			//2.预编译sql语句，返回PerparedStatement的实例
			ps = conn.prepareStatement(sql);
			//3.填充占位符
			for(int i = 0; i < args.length;i++) {
				ps.setObject(i+1, args[i]);
			}
			
			result = ps.executeQuery();
			//获取结果集的元数据 
			ResultSetMetaData re = result.getMetaData();
			//通过ResultSetMetaData获取结果集中的列数
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
		}finally {
			JDBCUtils.closeResource(conn, ps, result);
		}
		
		return null;
	}
	
	

	// 测试
	@Test
	public void test() throws Exception {
		String sql = "select id,name,email from customers where id < ?";
		List<Customer> list = getForList(Customer.class, sql, 8);
		list.forEach(System.out::println);
		
		String sql1 = "select order_id orderId,order_name orderName from `order` where order_id < ?";
		List<Order> orderList = getForList(Order.class, sql1 ,4);
		orderList.forEach(System.out::println);
	}
}



