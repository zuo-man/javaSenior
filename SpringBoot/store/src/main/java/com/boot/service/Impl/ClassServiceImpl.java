package com.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.bean.Class;
import com.boot.mapper.ClassMapper;
import com.boot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 因为 IService实现了很多方法，所以本类页需要实现IServiece所有方法，这时需要ServiceImpl
 * ServiceImpl<> ：对顶级IService的实现类
 *                  < 泛型：M 是mapper对象， T 是实体 >
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {






//    @Autowired
//    ClassMapper classMapper;
//
//    public Class getClassById(Integer cId){
//        return classMapper.getClass(cId);
//    }

}
