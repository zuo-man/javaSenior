package com.example.dao;

import com.example.pojo.Order;
import com.example.pojo.OrderItem;

import java.util.List;

/**
 * @create 2022-01-04 20:12
 */
public interface OrderItemDao {

    //保存订单项
    public int saveOrderItem(OrderItem orderItem);

    //根据订单号查询全部订单项
    public List<OrderItem> queryMyItemOrder(String orderId);

}
