package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pojo.Vrshop;
import com.shop.service.VrshopService;
import com.shop.mapper.VrshopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author shengda
* @description 针对表【vrshop】的数据库操作Service实现
* @createDate 2022-05-24 16:23:12
*/
@Service
public class VrshopServiceImpl extends ServiceImpl<VrshopMapper, Vrshop> implements VrshopService{

    @Autowired
    private VrshopMapper vrshopMapper;

    @Override
    public Vrshop getVrshopAndDesc(Integer id) {
        return vrshopMapper.selectVrshopAndDesc(id);
    }

    @Override
    public List<Vrshop> getVrshopAll() {
        return vrshopMapper.selectVrshopAll();
    }

    @Override
    public List<Vrshop> getVrshopPut() {
        return vrshopMapper.selectVrshopPut();
    }

    @Override
    public Integer putVrshopTotal() {
        return vrshopMapper.putVrshopTotal();
    }

    @Override
    public Vrshop getById(Integer sid) {
        return vrshopMapper.selectById(sid);
    }

    @Override
    public Integer getStockBySId(Integer sid) {
        return vrshopMapper.selectStockBySId(sid);
    }

    @Override
    public void updateStock(Integer stock, Integer sid) {
        vrshopMapper.updateStock(stock, sid);
    }
}




