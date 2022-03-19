package com.daoOptimum;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;


import com.bean.Customer;

/*
 * 此接口用于规范针对于customers表的常用操作
 */
public interface CustomerDAO {

	/**
	 * @Description 将cust对象添加到数据库中
	 * @dage 2021年11月22日下午5:45:28
	 * @param conn
	 * @param cust
	 */
	void inset(Connection conn, Customer cust);//public abstract省略
	
	/**
	 * @Description 针对于指定的id，删除表中的一条记录
	 * @dage 2021年11月22日下午5:46:49
	 * @param conn
	 * @param id
	 */
	void deleteById(Connection conn, int id);
	
	/**
	 * @Description 针对于内存中的cust对象，去修改数据表中的指定的记录
	 * @dage 2021年11月22日下午5:47:24
	 * @param conn
	 * @param cust
	 */
	void updateById(Connection conn, Customer cust);
	
	/**
	 * @Description 针对于指定id查询得到对应的Customer对象
	 * @dage 2021年11月22日下午5:48:52
	 * @param conn
	 * @param id
	 */
	Customer getCustomerById(Connection conn,int id);
	
	/**
	 * @Description 查询表中的所有记录构成的集合
	 * @dage 2021年11月22日下午6:24:33
	 * @param conn
	 * @return
	 */
	List<Customer> getAll(Connection conn);
	
	/**
	 * @Description 返回数据表中的数据条目数
	 * @dage 2021年11月22日下午6:25:40
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);
	
	/**
	 * @Description 返回数据表中的最大生日
	 * @dage 2021年11月22日下午6:27:42
	 * @param conn
	 * @return
	 */
	Date getMaxBirth(Connection conn);
}
