package com.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.pojo.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

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

    //获取上架商品
    List getPut();

}
