package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pojo.Ordersfor;
import com.shop.service.OrdersforService;
import com.shop.mapper.OrdersforMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author shengda
* @description 针对表【ordersfor】的数据库操作Service实现
* @createDate 2022-05-26 21:15:50
*/
@Service
public class OrdersforServiceImpl extends ServiceImpl<OrdersforMapper, Ordersfor> implements OrdersforService{

    @Autowired
    private OrdersforMapper ordersforMapper;

    @Override
    public List<Ordersfor> selectByOid(Integer oid) {
        return ordersforMapper.selectByOid(oid);
    }

    @Override
    public void removeByOid(Integer oid) {
        ordersforMapper.deleteByOid(oid);
    }

}




