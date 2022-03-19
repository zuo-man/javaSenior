package com.dbutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.bean.Customer;
import com.util.JDBCUtils;

/*
 * commons-dbutils 是Apache提供的一个开源JDBC工具类库，封装了针对于数据库的增删改查操作
 */
public class QueryRunnerTest {
	// 插入
	@Test
	public void testInsert() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();

			conn = JDBCUtils.getConnectionDruid();
			String sql = "insert into customers(name, email, birth)values(?,?,?)";
			int insertCount = runner.update(conn, sql, "伊克丝", "23@", "2002-02-23");
			System.out.println("添加了" + insertCount + "条数据");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 查询
	/*
	 * BeanHander：是ResultSetHandler接口的实现类，用于封装表中的一条记录
	 */
	// 查询一条记录
	@Test
	public void testQuery1() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnectionDruid();
			String sql = "select id, name, email, birth from customers where id = ?";

			BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);

			Customer customer = runner.query(conn, sql, handler, 30);
			System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	/*
	 * BeanListHander：是ResultSetHandler接口的实现类，用于封装表中的多条数据集合
	 */
	// 查询多条记录
	@Test
	public void testQuery2() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnectionDruid();
			String sql = "select id, name, email, birth from customers where id > ?";

			BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);

			List<Customer> list = runner.query(conn, sql, handler, 20);
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	/*
	 * MapHander：是ResultSetHandler接口的实现类，对应表中的一条记录 将字段及相应的值作为map中的key和value
	 */
	// 查询一条记录
	@Test
	public void testQuery3() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnectionDruid();
			String sql = "select id, name, email, birth from customers where id = ?";

			MapHandler handler = new MapHandler();

			Map<String, Object> map = runner.query(conn, sql, handler, 30);
			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	/*
	 * MapHander：是ResultSetHandler接口的实现类，对应表中的多条记录
	 * 将字段及相应的值作为map中的key和value，将这些map添加到list中
	 */
	// 查询多条记录
	@Test
	public void testQuery4() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnectionDruid();
			String sql = "select id, name, email, birth from customers where id > ?";

			MapListHandler handler = new MapListHandler();

			List<Map<String, Object>> list = runner.query(conn, sql, handler, 20);
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 查询表中记录数
	@Test
	public void testQuery5() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnectionDruid();
			String sql = "select count(*) from customers";

			ScalarHandler handler = new ScalarHandler();

			long count = (Long) runner.query(conn, sql, handler);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	/*
	 * ScalarHandler:用于查询特殊值
	 */
	// 查询表中最大生日
	@Test
	public void testQuery6() {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnectionDruid();
			String sql = "select max(birth) from customers";

			ScalarHandler handler = new ScalarHandler();

			Date maxBirth = (Date) runner.query(conn, sql, handler);
			System.out.println(maxBirth);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}
	
}






