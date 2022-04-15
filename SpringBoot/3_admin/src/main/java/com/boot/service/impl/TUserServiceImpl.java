package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.bean.TUser;
import com.boot.mapper.TUserMapper;
import com.boot.service.TUserService;
import org.springframework.stereotype.Service;


/**
 * 因为 IService实现了很多方法，所以本类页需要实现IServiece所有方法，这时需要ServiceImpl
 * ServiceImpl<> ：对顶级IService的实现类
 *                  < 泛型：M 是mapper对象， T 是实体 >
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {


}
