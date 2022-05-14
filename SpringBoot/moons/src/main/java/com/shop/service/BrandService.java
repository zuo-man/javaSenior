package com.shop.service;

import com.shop.pojo.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Dell
* @description 针对表【brand】的数据库操作Service
* @createDate 2022-04-27 21:00:56
*/
public interface BrandService extends IService<Brand> {

    //查询品牌名
    Brand getBrandName(String brandname);


}
