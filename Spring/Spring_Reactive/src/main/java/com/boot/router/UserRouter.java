package com.boot.router;

import com.boot.handler.UserHandler;
import com.boot.service.UserService;
import com.boot.service.impl.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class UserRouter {

    public static void main(String[] args) throws IOException {
        UserRouter router = new UserRouter();
        //启动服务，默认使用随机端口
        router.createReactorServer();
        System.out.println("enter to exit....");
        System.in.read();
    }

    //创建Router路由
    public RouterFunction<ServerResponse> routingFunction(){
        //创建handler对象
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);

        //设置路由
        return RouterFunctions.route(GET("/user/{id}").and(accept(APPLICATION_JSON)), handler::getUserById)
                            .andRoute(GET("/users").and(accept(APPLICATION_JSON)), handler::getAllUsers);
    }

    //创建服务器完成适配
    public void createReactorServer(){
        //路由和handler适配
        RouterFunction<ServerResponse> router = routingFunction();
        HttpHandler httpHandler = toHttpHandler(router);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        //创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }

}
