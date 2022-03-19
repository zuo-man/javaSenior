package com.example.dao;

import com.example.pojo.Order;
import com.example.pojo.User;

import java.util.List;

/**
 * @create 2022-01-04 20:09
 */
public interface OrderDao {

    //保存订单
    public int saveOrder(Order order);

    //根据用户ID查询订单
    public List<Order> queryMyIDOrder(Integer userId);

}
