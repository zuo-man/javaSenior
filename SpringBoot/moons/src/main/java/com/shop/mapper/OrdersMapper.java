package com.shop.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.pojo.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shengda
 * @description 针对表【orders】的数据库操作Mapper
 * @createDate 2022-05-25 11:05:51
 * @Entity com.shop.pojo.Orders
 */
@Repository
public interface OrdersMapper extends BaseMapper<Orders> {

    //更新订单
    void updateState(@Param("id") Integer id, @Param("state") String state,
                     @Param("paytime") String paytime, @Param("payNo") String payNo);

    //修改是否线下取货
    void updateIsdownById(@Param("id") Integer id, @Param("isdown") Integer isdown);

    //根据 Id查询订单信息
    Orders selectOrdersById(@Param("id") Integer id);


    List<Orders> selectByUid(@Param("uid") Integer uid);

    //图表，获取全部销售额
    List selectTotalAll();
    //图表，计算销售额
    Integer sumTotalAll();
    //图表，获取订单时间
    List selectCreateAll();
    //图表，支付笔数
    Integer payOrders();
    //图表，订单总数
    Integer ordersAll();


    Page selectOrders(@Param("page") Page page, @Param("user") String user,
                      @Param("state") String state, @Param("isdown") Integer isdown);


}




