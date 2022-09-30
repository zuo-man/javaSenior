package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pojo.Cart;
import com.shop.service.CartService;
import com.shop.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author shengda
* @description 针对表【cart】的数据库操作Service实现
* @createDate 2022-05-23 14:47:13
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService{

    @Autowired
    private CartMapper cartMapper;


    @Override
    public Cart getByUidAndSid(Integer uid, Integer sid) {
        return cartMapper.getByUidAndSid(uid, sid);
    }

    @Override
    public List<Cart> getByUidAll(Integer uid) {
        return cartMapper.getByUid(uid);
    }

    @Override
    public Page<Cart> getCartById(Page<Cart> page, Integer uid) {
        return cartMapper.selectCartById(page, uid);
    }

    @Override
    public void deleteCart(Integer uid) {
        cartMapper.deleteCart(uid);
    }

}




