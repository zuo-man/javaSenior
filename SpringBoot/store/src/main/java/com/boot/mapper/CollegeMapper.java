package com.boot.mapper;

import com.boot.bean.College;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Dell
* @description 针对表【college】的数据库操作Mapper
* @createDate 2022-05-02 12:33:52
* @Entity com.boot.bean.College
*/
@Repository
public interface CollegeMapper extends BaseMapper<College> {

}




