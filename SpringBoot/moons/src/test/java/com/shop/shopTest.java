package com.shop;

import com.shop.mapper.ShopMapper;
import com.shop.pojo.Shop;
import com.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class shopTest {

    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ShopService shopService;

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


}
