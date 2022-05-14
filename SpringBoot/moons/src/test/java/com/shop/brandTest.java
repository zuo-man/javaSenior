package com.shop;

import com.shop.pojo.Brand;
import com.shop.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
public class brandTest {

    @Autowired
    private BrandService brandService;

    @Test
    public void test1(){
        Map<String, Object> map = brandService.getMap(null);

        List<Brand> list = brandService.list(null);
        System.out.println(list);

    }

}
