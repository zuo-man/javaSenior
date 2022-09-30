package com.shop.service;

import com.shop.pojo.Ordersfor;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author shengda
* @description 针对表【ordersfor】的数据库操作Service
* @createDate 2022-05-26 21:15:50
*/
public interface OrdersforService extends IService<Ordersfor> {

    List<Ordersfor> selectByOid(@Param("oid") Integer oid);

    void removeByOid(@Param("oid") Integer oid);

}
