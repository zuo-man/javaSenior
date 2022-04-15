package com.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.bean.Class;
import org.apache.ibatis.annotations.Mapper;

/**
 * 只需要Mapper继承于 BaseMapper，就有CRUD
 */
//                                             TUser：标注查询数据对应对象
public interface ClassMapper extends BaseMapper<Class>{

}



//使用 mybatis -plus 此方法无用
//@Mapper
//public interface ClassMapper {
//
//    //使用xml配置 ：ClassMapper
//    public Class getClass(Integer eId);
//
//}
