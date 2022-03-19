package com.example.test;

import com.example.dao.OrderDao;
import com.example.dao.impl.OrderDaoImpl;
import com.example.pojo.Order;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @create 2022-01-04 20:28
 */
public class OrderDaoTest {

    @Test
    public void saveOrder(){
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("123",new Date(), new BigDecimal(12),0,1));
    }


    @Test
    public void queryMyIDorder(){
        OrderDao orderDao = new OrderDaoImpl();

        for(Order E : orderDao.queryMyIDOrder(11)){
            System.out.println(E);
        }
    }
}
