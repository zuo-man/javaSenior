package com.shop;

import com.shop.entity.ReUtil;
import com.shop.mapper.OrdersMapper;
import com.shop.mapper.ShopMapper;
import com.shop.pojo.Orders;
import com.shop.pojo.Shop;
import com.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootTest
public class shopTest {

    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ShopService shopService;
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void test1(){
        Shop shop = shopMapper.selectById(1);
        System.out.println(shop);
    }

    @Test
    public void test2(){
//        List<Shop> shop = shopMapper.selectShopAll();
//        System.out.println(shop);
    }

    @Test
    public void test3(){
        List list = shopMapper.selectPut();
        System.out.println(list);
    }

    @Test
    public void test4(){

        Integer random = Integer.valueOf(ReUtil.getRandom());

        System.out.println(random);
    }

    @Test
    public void test33(){
        Orders orders = ordersMapper.selectOrdersById(447887);
        System.out.println(orders);

    }

    @Test
    public void test5(){
        Orders orders = ordersMapper.selectById(447887);
        System.out.println(orders);
        if(orders.getPayNo() != null){
            System.out.println("sdf");
        }else {
            System.out.println("gg");
        }


        Orders orders1 = ordersMapper.selectById(1098403);
        System.out.println(orders1);
        if(orders1.getPayNo() != null){
            System.out.println("rrr");
        }else {
            System.out.println("eee");
        }
    }

}
