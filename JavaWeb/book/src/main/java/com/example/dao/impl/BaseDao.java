package com.example.dao.impl;

import com.example.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @create 2021-12-12 13:29
 */
public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner runner = new QueryRunner();

    /**
     * update() 方法用来执行，Insert\Update\Dalete语句
     */
    public int update(String sql,Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            /*
             * 若在后面的OrderDao.saveOrder()中出了异常，之后的提交和回滚事务不能捕获到此异常
             * 事务捕获不到异常，不能有效的回滚。
             * 所以在DAO中，有异常，一定要往外抛！
             */
            throw new RuntimeException(e);
        }
        /*
         *  结合了事务，如果在DAO里执行一次就把连接关闭，后面的操作就不能获取连接，
         *  连接只有在事务提交或回滚之后才能关闭
         */
    }

    /**
     * BeanHander:是ResultSetHandler接口的实现类，用于封装表中的一条记录。
     *            查询返回一个javeBean的sql语句
     * @param type 返回的对象类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @param <T>   返回类型泛型
     */
    public <T> T queryForOne(Class<T> type,String sql,Object... args){ //class<T> 获取UerDaoImpl传过来的user.class
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    /**
     * 查询返回多个javeBean的sql语句
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     * ScalarHandler:用于查询特殊值
     */
    public Object queryForSingleValue(String sql, Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
