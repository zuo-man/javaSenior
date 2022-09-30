package com.shop;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.mapper.CartMapper;
import com.shop.mapper.OrdersMapper;
import com.shop.pojo.Cart;
import com.shop.pojo.Orders;
import com.shop.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class cartTest {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void test1(){

//        Cart byUid = cartMapper.getByUid(2);

//        List<Cart> uid = cartService.getByUid(5);
        //是否为空
//        if(uid.isEmpty()){
//            System.out.println("sdf");
//        }else {
//            System.out.println("fff");
//        }
//
//        System.out.println(uid);

    }


    @Test
    public void test2(){

    }


}
