package mq_boot.controller;

import lombok.extern.slf4j.Slf4j;
import mq_boot.config.DelayedExchangeConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 发送延迟消息
 * http://localhost:8080/ttl/sendMsg/
 */

@RestController
@RequestMapping("/ttl")
@Slf4j
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //发消息  ，基于插件及延迟时间
    @GetMapping("/sendDelayed/{message}/{delayedTime}")
    public void sendMsg(@PathVariable String message, @PathVariable Integer delayedTime){
        log.info("当前时间：{}，发送一条时长是：{} 毫秒信息给交换机DelayedExchange：{}", new Date().toString(), delayedTime, message);


        rabbitTemplate.convertAndSend(DelayedExchangeConfig.DELAYED_EXCHANGE,
                DelayedExchangeConfig.DELAYED_ROUTINGKEY, message, msg -> {
                    //发送消息的时候  延迟时长     ms
                    msg.getMessageProperties().setDelay(delayedTime);
                    return msg;
                });
    }




    //发消息   ，基于TTL
    @GetMapping("/sendMsg/{message}")
    public void senMsg(@PathVariable("message") String message){

        log.info("当前时间：{}，发送一条信息给两个过期时间不同的TTL队列：{}", new Date().toString(), message);

                                            // X：x交换机    XA：RountingKey
        rabbitTemplate.convertAndSend("X","XA", "消息来自 过期时间TTL 5s的队列：" + message);
        rabbitTemplate.convertAndSend("X","XB", "消息来自 过期时间TTL 20s的队列：" + message);
    }

    //发消息   ，基于TTL
    @GetMapping("/send/{message}/{ttlTime}")
    public void senMsg(@PathVariable("message") String message, @PathVariable("ttlTime") String ttlTime){

        log.info("当前时间：{}，发送一条时长是：{} 信息TTL队列给T：{}", new Date().toString(), ttlTime, message);

                                    // X：x交换机     RountingKey：TKey
        rabbitTemplate.convertAndSend("X","TKey", "消息来自 的队列：" + message, msg -> {
                    //发送消息的时候  延迟时长
            msg.getMessageProperties().setExpiration(ttlTime);
            return msg;
        });
    }


}
