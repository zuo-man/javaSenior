package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pojo.Orders;
import com.shop.service.OrdersService;
import com.shop.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shengda
 * @description 针对表【orders】的数据库操作Service实现
 * @createDate 2022-05-25 11:05:51
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService{

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public void updateState(Integer id, String state, String paytime, String payNo) {
        ordersMapper.updateState(id, state, paytime, payNo);
    }

    @Override
    public Orders getOrdersById(Integer id) {
        return ordersMapper.selectOrdersById(id);
    }

    @Override
    public void updateIsdownById(Integer id, Integer isdown) {
        ordersMapper.updateIsdownById(id, isdown);
    }

    @Override
    public List<Orders> getByUid(Integer uid) {
        return ordersMapper.selectByUid(uid);
    }

    @Override
    public List getTotalAll() {
        return ordersMapper.selectTotalAll();
    }

    @Override
    public Integer sumTotalAll() {
        return ordersMapper.sumTotalAll();
    }

    @Override
    public List getCreateAll() {
        return ordersMapper.selectCreateAll();
    }

    @Override
    public Integer payOrders() {
        return ordersMapper.payOrders();
    }

    @Override
    public Integer ordersAll() {
        return ordersMapper.ordersAll();
    }

    @Override
    public Page getOrders(Page page, String user, String state, Integer isdown) {
        return ordersMapper.selectOrders(page, user, state, isdown);
    }


}








