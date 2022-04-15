package mq_boot.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import mq_boot.config.DelayedExchangeConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

//基于插件延迟  消费者
@Slf4j
@Component
public class DelayConsumer {

    // 监听延迟 交换机到队列 的消息
    @RabbitListener(queues = DelayedExchangeConfig.DELAYED_QUEUE )
    public void receiveD(Message message) throws Exception{
        String msg = new String(message.getBody());
        log.info("当前时间：{}，收到延迟队列的消息：{}", new Date().toString(), msg);
    }

}
