package com.example.service.impl;

import com.example.dao.*;
import com.example.dao.impl.*;
import com.example.pojo.*;
import com.example.service.OrderService;

import java.util.*;

/**
 * @create 2022-01-04 20:45
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    public String createOrder(Cart cart, Integer userId) {
        //先保存订单，再保存订单项  订单项需要订单号order_id外键元素
        //订单号--->唯一性   时间戳 + userId用户Id
        String orderId = System.currentTimeMillis() + "" + userId;
        //创建一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        //保存订单
        orderDao.saveOrder(order);

        //遍历购物车中每一个商品项转化成为订单项保存到数据库中
        //Map<Integer, CartItem>： key是商品编号，value是商品信息
        for(Map.Entry<Integer, CartItem>entry : cart.getItemList().entrySet()){
            //每一个cartItem都是一个订单项  、获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            //订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales( book.getSales() + cartItem.getCount() );//销量
            book.setStock( book.getStock() - cartItem.getCount() );//库存
            bookDao.updateBook(book);
        }

        //清空购物车
        cart.clear();

        return orderId;
    }

    @Override   //根据传递过来的用户ID查询订单编号
    public List<Order> queryMyIDOrder(Integer userId) {
        List<Order> orders = orderDao.queryMyIDOrder(userId);
        return orders;
    }


    @Override   //项目orderId查询订单项
    public List<OrderItem> queryMyItemOrder(String orderId) {
        List<OrderItem> orderItems = orderItemDao.queryMyItemOrder(orderId);
        return orderItems;
    }
}
