package com.boot.controller;

import com.boot.bean.User;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * SpringWebflux 实现方式有两种：注解编程模型和函数式编程模型
 *
 * 基于注解编程模型 响应式编程
 * 用注解编程模型方式，和之前 SpringMVC 使用相似的，只需要把相关依赖配置到项目中，
 * SpringBoot 自动配置相关运行容器，默认情况下使用 Netty 服务器
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //id查询
    @GetMapping("/user/{id}")
    public Mono<User> getUserByid(@PathVariable int id){
        return userService.getUserById(id);
    }

    //查询所有用户
    @GetMapping("/user")
    public Flux<User> getUsers(){
        return userService.getAllUser();
    }

    //添加
    @PostMapping("/save")
    public Mono<Void> saveUser(@RequestBody User user){
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);
    }

}
