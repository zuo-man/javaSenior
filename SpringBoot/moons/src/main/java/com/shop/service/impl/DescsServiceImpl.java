package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pojo.Descs;
import com.shop.service.DescsService;
import com.shop.mapper.DescsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author shengda
* @description 针对表【descs】的数据库操作Service实现
* @createDate 2022-05-25 12:04:18
*/
@Service
public class DescsServiceImpl extends ServiceImpl<DescsMapper, Descs> implements DescsService{

    @Autowired
    private DescsMapper descsMapper;

    @Override
    public List<Descs> getByVid(Integer vid) {
        return descsMapper.selectByVid(vid);
    }

    @Override
    public List<Descs> getDescsAll() {
        return descsMapper.selectDescsAll();
    }
}




