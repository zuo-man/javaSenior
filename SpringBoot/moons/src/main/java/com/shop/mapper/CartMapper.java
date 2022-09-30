package com.shop.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.pojo.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author shengda
* @description 针对表【cart】的数据库操作Mapper
* @createDate 2022-05-23 14:47:13
* @Entity com.shop.pojo.Cart
*/
@Repository
public interface CartMapper extends BaseMapper<Cart> {

    //分页查询用户ID
    Page<Cart> selectCartById(@Param("page") Page<Cart> page, @Param("uid") Integer uid);


    Cart getByUidAndSid(@Param("uid") Integer uid, @Param("sid") Integer sid);

    //获取某个用户购物车全部信息
    List<Cart> getByUid(@Param("uid") Integer uid);

    //删除以用户名为字段的 所有购物车
    void deleteCart(@Param("uid") Integer uid);

}



