package com.example.test;

import com.example.dao.OrderItemDao;
import com.example.dao.impl.OrderItemDaoImpl;
import com.example.pojo.Order;
import com.example.pojo.OrderItem;
import com.example.utils.WebUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


/**
 * @create 2022-01-04 20:34
 */
public class OrderItemDaoTest {
    @Test
    public void saveOrderItem(){
        OrderItemDao orderItemDao = new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java",1,new BigDecimal(10),new BigDecimal(10),"123"));
        orderItemDao.saveOrderItem(new OrderItem(null,"无暇",2,new BigDecimal(23),new BigDecimal(46),"123"));
        orderItemDao.saveOrderItem(new OrderItem(null,"小优",1,new BigDecimal(11),new BigDecimal(11),"123"));
    }

    @Test   //根据订单号查询全部订单项
    public void queryMyItemOrder(){
        OrderItemDao orderItemDao = new OrderItemDaoImpl();

        List<OrderItem> orders = orderItemDao.queryMyItemOrder("164138516296920");

        System.out.println(orders);
    }
}
