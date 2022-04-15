package mq_boot.consumer;

import lombok.extern.slf4j.Slf4j;
import mq_boot.config.ConfirmConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WarningConsumer {

    //接受报警信息
    @RabbitListener(queues = ConfirmConfig.WARNING_QUEUE)
    public void receiveWarningMsg(Message message){

        String msg = new String(message.getBody());
        log.error("报警发现不可用路由信息：{}", msg);
    }

}
