package com.shop.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.shop.pojo.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author shengda
* @description 针对表【brand】的数据库操作Mapper
* @createDate 2022-04-27 21:00:56
* @Entity com.shop.pojo.Brand
*/
@Repository
public interface BrandMapper extends BaseMapper<Brand> {

    Brand selectByBrandname(@Param("brandname") String brandname);

}




