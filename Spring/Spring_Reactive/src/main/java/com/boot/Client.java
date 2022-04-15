package com.boot;

//模拟客户端进行调用

import com.boot.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Client {

    public static void main(String[] args) {
        //调用服务器地址，随机的
        WebClient webClient = WebClient.create("http://localhost:5597");

        //根据id查询用户
        String id = "1";
        User user = webClient.get().uri("/user/{id}", id).accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(User.class).block();

        System.out.println(user);

        //查询所有用户
        Flux<User> users = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(User.class);
        users.map(stu -> stu.getName()).buffer().doOnNext(System.out::println).blockFirst();

    }
}
