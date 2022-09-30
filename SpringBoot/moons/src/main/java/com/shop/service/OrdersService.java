package com.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.pojo.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shengda
 * @description 针对表【orders】的数据库操作Service
 * @createDate 2022-05-25 11:05:51
 */
@Repository
public interface OrdersService extends IService<Orders> {

    void updateState(Integer id, String state, String paytime, String payNo);

    Orders getOrdersById(Integer id);

    void updateIsdownById(Integer id, Integer isdown);

    List<Orders> getByUid(Integer uid);

    List getTotalAll();
    Integer sumTotalAll();
    List getCreateAll();
    Integer payOrders();
    Integer ordersAll();

    Page getOrders(Page page, String user, String state, Integer isdown);

}