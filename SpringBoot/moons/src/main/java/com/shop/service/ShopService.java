package com.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.pojo.Shop;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author shengda
* @description 针对表【shop】的数据库操作Service
* @createDate 2022-04-27 15:30:47
*/
public interface ShopService extends IService<Shop> {

    //模糊查询 Shop分页
    Page pageShop(Page page, String shopname, String type, String origin, String  brandname,
                  String isput, String sort);

    List getUnityShop();

    //获取上架商品
    List getPut();

    //获取首页轮播图商品
    List getTop();

    List getSalesAll();
    List getShopNameAll();
    Integer sumSalesAll();

    Integer getStockBySId(Integer sid);
    void updateStock(Integer stock, Integer sid);

    Integer getSales(Integer sid);
    void updateSales(Integer sales, Integer sid);

    Integer putshopTotal();

}
