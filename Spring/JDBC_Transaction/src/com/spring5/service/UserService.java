package com.spring5.service;

import com.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

/**在 service 类上面（或者 service 类里面方法上面）添加事务注解
        （1）@Transactional，这个注解添加到类上面，也可以添加方法上面
            如果把这个注解添加类上面，这个类里面所有的方法都添加事务
            如果把这个注解添加方法上面，为这个方法添加事务

        （2）propagation：设置事务传播行为 ，默认为REQUIRED
        （3）isolation：设置事务隔离级别，mysql默认隔离级别为REPEATABLE_READ
        （4）timeout：设置事务超时时间.  事务需要在一定时间内进行提交，若不提交则进行回滚，默认值为 -1（不超时），以秒进行设置
        （5）readOnly：设置事务是否只读，默认值false，表示可以查询，可以增删改
        （6）rollbackFor：设置出现哪些异常进行回滚事务
        （7）noRollbackFor：设置出现哪些异常不进行事务回滚
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ,
                timeout = -1,readOnly = false)
@Service
public class UserService {
    //注入dao
    @Autowired
    private UserDao userDao;

    //转账
    public void account(){
        //声明式事务管理，使用注解Transactioal
        //小优少100
        userDao.reduceMoney();

        //异常
        int i = 10/0;

        //无暇多100
        userDao.addMoney();





        //编程式事务管理（不推荐）
//        try {
//            //第一步，开启事务
//
//            //第二步，业务操作
//            //小优少100
//            userDao.reduceMoney();
//
//            //异常
////        int i = 10/0;
//
//            //无暇多100
//            userDao.addMoney();
//
//            //第三步，没有发生异常，提交事务
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
