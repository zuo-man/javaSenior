package com.cloud.service.impl;

import com.cloud.service.ImessagePrivider2;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @EnableBinding 源码中明确声明
 * 该注解在从3.1版本开始被弃用，推荐使用函数编程的方式
 *
 * @Autowire 注解自动注入StreamBridge的实例，省去了@Autowire注解
 * StreamBridge的send方法第一个参数是binding的名字，第二个参数是想要发送的消息
 */

@Service
public class MessageProviderImpl2 implements ImessagePrivider2 {

    private final StreamBridge streamBridge;

    public MessageProviderImpl2(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        streamBridge.send("myChannel-out-0", MessageBuilder.withPayload(serial).build());
        System.out.println("函数式编程方式，发送消息: " + serial);
        return null;
    }
}
