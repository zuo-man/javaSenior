package com.example.service;

import com.example.pojo.*;

import java.util.List;

/**
 * @create 2022-01-04 20:43
 */
public interface OrderService {

    //生成订单
    public String createOrder(Cart cart, Integer userId);

    //根据传递过来的用户ID查询订单编号
    public List<Order> queryMyIDOrder(Integer userId);

    //根据订单号查询全部订单项
    public List<OrderItem> queryMyItemOrder(String orderId);

}
