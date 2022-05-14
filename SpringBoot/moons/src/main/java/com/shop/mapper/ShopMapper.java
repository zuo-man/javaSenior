package com.shop.mapper;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.pojo.Shop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @author shengda
* @description 针对表【shop】的数据库操作Mapper
* @createDate 2022-04-27 15:30:47
* @Entity com.shop.pojo.Shop
*/
@Repository
public interface ShopMapper extends BaseMapper<Shop> {

    /**
     * 自定义方法，模糊查询
     * Page ：mybatis-plus提供的分页对象，必须位于第一个参数的位置，才能被分页拦截器拦截
     */
    //@Param：规定参数访问规则
    Page selectShopAll(@Param("page") Page page, @Param("shopname") String shopname,
                       @Param("type") String type, @Param("origin") String origin,
                       @Param("brandname") String brandname,
                       @Param("isput") String isput, @Param("sort") String sort);

    //获取上架商品
    List selectPut();



}




