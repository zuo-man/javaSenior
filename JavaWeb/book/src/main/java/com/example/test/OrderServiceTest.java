package com.example.test;

import com.example.pojo.*;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import org.junit.Test;


import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

/**
* @create 2022-01-05 13:16
*/
public class OrderServiceTest {
    @Test
    public void creterOder(){
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"无暇",1,new BigDecimal(22),new BigDecimal(22)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println("订单号为：" + orderService.createOrder(cart,1));
    }

    @Test
    public void queryMyIDorder(){
        OrderService orderService = new OrderServiceImpl();

        List<Order> orders = orderService.queryMyIDOrder(20);
        System.out.println(orders);

        for(Order E : orderService.queryMyIDOrder(11)){

            Order order = new Order(E.getOrderId(),E.getCreateTime(),E.getPrice(),E.getStatus(),E.getUserId());

            System.out.println(order);
        }
    }

    @Test
    public void test1(){
        Date d = new Date();

        System.out.println(d);
    }

    @Test
    public void queryMyItemOrder(){
        OrderService orderService = new OrderServiceImpl();

        List<OrderItem> orderItems = orderService.queryMyItemOrder("164138516296920");

        System.out.println(orderItems);
    }


}
