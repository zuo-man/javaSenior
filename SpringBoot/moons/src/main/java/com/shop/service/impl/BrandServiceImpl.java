package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pojo.Brand;
import com.shop.service.BrandService;
import com.shop.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author shengda
* @description 针对表【brand】的数据库操作Service实现
* @createDate 2022-04-27 21:00:56
*/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService{

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Brand getBrandName(String brandname) {
        return brandMapper.selectByBrandname(brandname);
    }
}




