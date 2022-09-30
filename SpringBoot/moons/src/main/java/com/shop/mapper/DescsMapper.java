package com.shop.mapper;

import com.shop.pojo.Descs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author shengda
* @description 针对表【descs】的数据库操作Mapper
* @createDate 2022-05-25 12:04:18
* @Entity com.shop.pojo.Descs
*/
@Repository
public interface DescsMapper extends BaseMapper<Descs> {


    List<Descs> selectByVid(@Param("vid") Integer vid);

    List<Descs> selectDescsAll();

}




