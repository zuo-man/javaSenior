package com.cloud.service.impl;

import com.cloud.service.ImessageProvider;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @EnableBinding ：指信道channel和exchange绑定在一起
 */

@EnableBinding(Source.class)    //定义消息的推送管道
public class MessageProviderImpl implements ImessageProvider {

    @Resource
    private MessageChannel output;  //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("@EnableBinding注解，发送消息： " + serial);

        return null;
    }
}
