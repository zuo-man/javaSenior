package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pojo.Shop;
import com.shop.service.ShopService;
import com.shop.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author shengda
* @description 针对表【shop】的数据库操作Service实现
* @createDate 2022-04-27 15:30:47
*/
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService{

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Page pageShop(Page page, String shopname, String type, String origin, String brandname, String isput, String sort) {
        return shopMapper.selectShopAll(page, shopname, type, origin, brandname, isput, sort);
    }

    @Override
    public List getPut() {
        List list = shopMapper.selectPut();
        return list;
    }

}




