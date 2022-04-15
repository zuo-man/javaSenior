package com.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.bean.TUser;

/**
 * IService：service层总接口，        我觉得是对应着BaseMapper的所有方法，就能实现调用
 * <> ：查询哪些数据类型，对TUser这个进行 CRUD
 */
public interface TUserService extends IService<TUser> {


}
