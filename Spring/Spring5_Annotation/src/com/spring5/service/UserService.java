package com.spring5.service;

import com.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//在注解里面value属性可以省略
//默认值是类名称，首字母小写   UserService -> userService   ，以下四种注解都可以

//@Component(value = "userService")  //相当于 -> <bean id="user" class="..."/>
//@Repository
//@Controller
@Service
public class UserService {

    /**
     *  @Value 注入普通类型属性
     */
    @Value(value = "小优")
    private String name;

    /**
     * 定义dao类型属性
     * 注解中已经封装set方法，不需要添加 set 方法
     * 添加注入属性 @Autowired注解
     */
//    @Autowired
    /**
     * 当UserDao有多个实现类时，属性类型注解Autowired 无法知道要注解哪一个类
     * 此时需要名称类型注解 @Qualifier，确定注解具体哪一个类
     * 且注解 @qualifier需要和上面 @Autowired 一起使用
     */
//    @Qualifier(value = "userDaoImplXXX")

    /**
     *  可以根据类型注入，可以根据名称注入
     *  UserDao只有一个实现类时，类型注入，  多个实现类时，需要按照名称进行注入
      */
//    @Resource  //根据类型注入
    @Resource(name = "userDaoImpl")   //根据名称注入
    private UserDao userDao;


    public void add(){
        System.out.println("服务层 add方法调用..." + name);

        userDao.add();
    }
}
