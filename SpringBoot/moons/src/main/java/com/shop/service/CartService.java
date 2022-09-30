package com.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.pojo.Cart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author shengda
* @description 针对表【cart】的数据库操作Service
* @createDate 2022-05-23 14:47:13
*/

public interface CartService extends IService<Cart> {

    Page<Cart> getCartById(Page<Cart> page, Integer uid);

    Cart getByUidAndSid(Integer uid, Integer sid);

    //获取某个用户购物车全部信息
    List<Cart> getByUidAll(Integer uid);


    void deleteCart(Integer uid);
}