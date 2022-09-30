package com.shop;

import com.shop.mapper.VrshopMapper;
import com.shop.pojo.Vrshop;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class vrshopTest {

    @Autowired
    private VrshopMapper vrshopMapper;

    @Test
    public void test1(){
//        Vrshop vrshopAndDesc = vrshopMapper.getVrshopAndDesc(7589);

//        System.out.println(vrshopAndDesc);
    }



}
