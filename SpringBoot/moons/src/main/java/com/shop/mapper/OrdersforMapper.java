package com.shop.mapper;

import com.shop.pojo.Ordersfor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author shengda
* @description 针对表【ordersfor】的数据库操作Mapper
* @createDate 2022-05-26 21:15:50
* @Entity com.shop.pojo.Ordersfor
*/
@Repository
public interface OrdersforMapper extends BaseMapper<Ordersfor> {

    List<Ordersfor> selectByOid(@Param("oid") Integer oid);


    void deleteByOid(@Param("oid") Integer oid);

}





