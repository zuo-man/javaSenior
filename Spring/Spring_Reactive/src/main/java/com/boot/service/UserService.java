package com.boot.service;

import com.boot.bean.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    /**
     * Mono：返回 0 到 1个元素
     * Flux：返回多个元素
     */

    //根据id查询用户
    Mono<User> getUserById(int id);

    //查询所有用户
    Flux<User> getAllUser();

    //添加用户
    Mono<Void> saveUserInfo(Mono<User> user);

}
