package com.cloud.controller;

import com.cloud.service.ImessagePrivider2;
import com.cloud.service.impl.MessageProviderImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenMessageController2 {

    //单例模式
    private final ImessagePrivider2 messageProvider;

    public SenMessageController2(ImessagePrivider2 messageProvider) {
        this.messageProvider = messageProvider;
    }

    //注解模式，但还是单例
//    @Autowired
//    private ImessagePrivider2 messageProvider;

    @GetMapping("/sendMessage2")
    public String sendMessage() {
        return messageProvider.send();
    }


}
