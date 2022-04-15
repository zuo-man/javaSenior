package com.boot.service.impl;

import com.boot.bean.User;
import com.boot.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * * 下面四个注解功能是一样的，都可以用来创建 bean 实例
 *
 * 1、@controller：   controller控制器层（注入服务）
 * 2、@service ：     service服务层（注入dao）
 * 3、@repository ：  dao持久层（实现dao访问）
 * 4、@component：    标注一个类为Spring容器的Bean
 */
@Repository
public class UserServiceImpl implements UserService {

    //创建 map集合模拟数据库存储数据
    private final Map<Integer, User> users = new HashMap<>();
    public UserServiceImpl(){
        this.users.put(1, new User("小优", 20));
        this.users.put(2, new User("无暇", 21));
        this.users.put(3, new User("艾琳", 18));
    }

    //根据id查询
    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get((id)));
    }

    //查询多个用户
    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    //添加用户
    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        /**
         * 把值取到，再用doOnNext将userMono 转成 person对象
         * Mono.empty()：把值清空，也就是终止信号
         */

        return userMono.doOnNext(person -> {
            //向map集合里面放值
            int id = users.size() + 1;
            users.put(id, person);
        }).thenEmpty(Mono.empty());
    }
}
