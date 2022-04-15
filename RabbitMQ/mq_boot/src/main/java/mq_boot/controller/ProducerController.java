package mq_boot.controller;

import lombok.extern.slf4j.Slf4j;
import mq_boot.config.ConfirmConfig;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 发消息  发布确认
@Slf4j
@RestController
@RequestMapping("/confirm")
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg/{message}")
    public void sendMsg(@PathVariable String message){
        //正常消息
        CorrelationData correlationData1 = new CorrelationData("1");

        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE,
                ConfirmConfig.CONFIRM_ROUTINGKEY, message + "消息 1", correlationData1);

        log.info("发布确认，发布消息内容：{}" + message + "正常消息 ");



        //写错 routingKey， 当路由没收到消息时，回退消息给生产者
        CorrelationData correlationData2 = new CorrelationData("2");

        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE,
                ConfirmConfig.CONFIRM_ROUTINGKEY + "2", message + "消息 2", correlationData2);

        log.info("发布确认，发布消息内容：{} " + message + "回退消息");
    }

}
