package com.shop.service;

import com.shop.pojo.Descs;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author shengda
* @description 针对表【descs】的数据库操作Service
* @createDate 2022-05-25 12:04:18
*/
public interface DescsService extends IService<Descs> {

    List<Descs> getByVid(@Param("vid") Integer vid);

    List<Descs> getDescsAll();

}
