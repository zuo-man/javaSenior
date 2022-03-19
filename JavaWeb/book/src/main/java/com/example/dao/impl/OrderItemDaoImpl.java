package com.example.dao.impl;

import com.example.dao.OrderItemDao;
import com.example.pojo.Order;
import com.example.pojo.OrderItem;

import java.util.List;

/**
 * @create 2022-01-04 20:25
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override  //保存订单项
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) value(?,?,?,?,?)";

        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override       //根据订单号查询全部订单项
    public List<OrderItem> queryMyItemOrder(String orderId) {
        String sql = "select `name`, `count`, `price`, `total_price` totalPrice from t_order_item where order_id = ?";

        return queryForList(OrderItem.class, sql, orderId);
    }
}
