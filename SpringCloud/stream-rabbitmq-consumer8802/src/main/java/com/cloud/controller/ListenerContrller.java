package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @EnableBinding 注解方式接受消息
 */

@Component

@EnableBinding(Sink.class)
public class ListenerContrller {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String>message){

        System.out.println("消费者 1接受消息：" + message.getPayload() + "\t  port ：" + serverPort);
    }

}
