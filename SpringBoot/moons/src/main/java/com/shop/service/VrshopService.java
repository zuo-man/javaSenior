package com.shop.service;

import com.shop.pojo.Vrshop;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author shengda
* @description 针对表【vrshop】的数据库操作Service
* @createDate 2022-05-24 16:23:12
*/
public interface VrshopService extends IService<Vrshop> {


    Vrshop getVrshopAndDesc(@Param("id") Integer id);


    List<Vrshop> getVrshopAll();

    List<Vrshop> getVrshopPut();

    Integer putVrshopTotal();

    Vrshop getById(Integer sid);


    Integer getStockBySId(Integer sid);
    //减库存
    void updateStock(Integer stock, Integer sid);
}
