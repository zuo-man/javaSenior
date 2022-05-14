package com.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * 函数编程的方式接受消息
 * yml配置中的通道名，应用程序启动后会自动接收生产者发送的消息
 */

@Service
@Slf4j
public class ListenerController2 {
    @Bean
    public Consumer<String> myChannel() {
        return message -> log.info("消息：" + message);
    }

}