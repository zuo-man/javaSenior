package com.example.dao.impl;

import com.example.dao.OrderDao;
import com.example.pojo.*;

import java.util.List;

/**
 * @create 2022-01-04 20:13
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override  //保存订单
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) value(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }


    @Override    //根据用户ID查询订单
    public List<Order> queryMyIDOrder(Integer userId) {
        String sql = "select `order_id` orderId , `create_time` createTime, `price`, `status`, `user_id` userId from t_order where user_id = ?";

        return queryForList(Order.class, sql, userId);
    }

}
