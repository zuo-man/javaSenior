package com.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.bean.TUser;

/**
 * 只需要Mapper继承于 BaseMapper，就有CRUD
 */
//                                             TUser：标注查询数据对应对象
public interface TUserMapper extends BaseMapper<TUser> {


}
