package com.boot.handler;

import com.boot.bean.User;
import com.boot.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 基于 基于函数式编程模型
 * （1）在使用函数式编程模型操作时候，需要自己初始化服务器
 * （2）基于函数式编程模型时候，有两个核心接口：RouterFunction（实现路由功能，请求转发
 *      给对应的 handler）和 HandlerFunction（处理请求生成响应的函数）。核心任务定义两个函数式接口的实现并且启动需要的服务器。
 * （ 3 ） SpringWebflux请求和响应不再是 ServletRequest 和 ServletResponse ，而是ServerRequest 和 ServerResponse
 */
public class UserHandler {

    //传入userService对象
    private final UserService userService;
    public UserHandler(UserService userService){
        this.userService = userService;
    }

    //根据id查询用户
    public Mono<ServerResponse> getUserById(ServerRequest request){
        //获取id值， 强转成int类型
        int userId = Integer.valueOf( request.pathVariable("id") );
        //空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        //调用service方法得到数据
        Mono<User> userMono = this.userService.getUserById(userId);
        //把userMono进行转换返回，使用Reactor操作符flatMap
        //flatMap：把对象转成流，把多个流合成一个大流

//        return userMono.flatMap(person -> ServerResponse.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(fromObject(person))).switchIfEmpty(notFound);
        //或者写成：
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userMono, User.class);
    }

    //查询所有用户
    public Mono<ServerResponse> getAllUsers(ServerRequest request){
        //调用service得到结果
        Flux<User> users = this.userService.getAllUser();
        return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
    }

    //添加
    public Mono<ServerResponse> saveUser(ServerRequest request){
        //得到user对象
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
    }
}
