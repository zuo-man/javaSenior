package com.cloud.controller;

import com.cloud.service.ImessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private ImessageProvider message;

    @GetMapping("/sendMessage")
    public String sendMessage(){

        return message.send();
    }

}
