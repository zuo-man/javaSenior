package mq_boot.consumer;

import lombok.extern.slf4j.Slf4j;
import mq_boot.config.ConfirmConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//接受消息
@Slf4j
@Component
public class ConfirmConsummer {


    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE)
    public void receiveConfirmMsg(Message message){
        String s = new String(message.getBody());

        log.info("接受到的Confirm队列 消息：{}", s);
    }

}
