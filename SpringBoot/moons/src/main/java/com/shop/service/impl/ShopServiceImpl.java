package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pojo.Shop;
import com.shop.service.ShopService;
import com.shop.mapper.ShopMapper;
import io.swagger.models.auth.In;
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
    public List getUnityShop() {
        return shopMapper.selectUnityShop();
    }

    @Override
    public List getPut() {
        List list = shopMapper.selectPut();
        return list;
    }

    @Override
    public List getTop() {
        List list = shopMapper.selectTop();
        return list;
    }

    @Override
    public List getSalesAll() {
        return shopMapper.selectSalesAll();
    }

    @Override
    public List getShopNameAll() {
        return shopMapper.selectShopNameAll();
    }

    @Override
    public Integer sumSalesAll() {
        return shopMapper.sumSalesAll();
    }


    @Override
    public Integer getStockBySId(Integer sid) {
        return shopMapper.selectStockBySId(sid);
    }

    @Override
    public void updateStock(Integer stock, Integer sid) {
        shopMapper.updateStock(stock, sid);
    }

    @Override
    public Integer getSales(Integer sid) {
        return shopMapper.selectSales(sid);
    }

    @Override
    public void updateSales(Integer sales, Integer sid) {
        shopMapper.updateSales(sales, sid);
    }

    @Override
    public Integer putshopTotal() {
        return shopMapper.putshopTotal();
    }

}




