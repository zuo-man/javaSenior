package com.shop.mapper;

import com.shop.pojo.Vrshop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author shengda
* @description 针对表【vrshop】的数据库操作Mapper
* @createDate 2022-05-19 14:45:46
* @Entity com.shop.pojo.Vrshop
*/
@Repository
public interface VrshopMapper extends BaseMapper<Vrshop> {

    //获取VR商品以及对应描述
    Vrshop selectVrshopAndDesc(@Param("id") Integer id);

    //查询全部VR商品
    List<Vrshop> selectVrshopAll();

    //查询上架VR商品
    List<Vrshop> selectVrshopPut();

    // 获取VR上架商品数量
    Integer putVrshopTotal();

    //根据ID查询VR商品
    Vrshop selectById(@Param("sid") Integer sid);

    //获取库存
    Integer selectStockBySId(@Param("sid") Integer sid);
    //减库存
    void updateStock(@Param("stock") Integer stock, @Param("sid") Integer sid);



}




