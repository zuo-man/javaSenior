package mq_boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// 发布确认 实现类 回调接口
@Slf4j
@Component
public class MyCallBack implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        //注入  确认回调
        rabbitTemplate.setConfirmCallback(this);
        //注入  回退
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     *  交换机确认回调方法
     *  1.发消息  交换机成功接受  回调
     *      1.1 correlationData ：保存回调消息的ID 及相关信息
     *      1.2 交换机收到消息 ack = true
     *      1.3 cause 为 null
     *
     *   2.发消息 交换机接受失败  回调
     *      2.1 conrrlationData ：保存回调信息的ID 及相关信息
     *      2.2 交换机收到消息 ack = false
     *      2.3 cause 为 失败的原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        //三元运算
        String id = correlationData != null ? correlationData.getId() : "";
        if(ack){
            log.info("交换机已经收到ID为：{}的消息", id);
        }else {
            log.info("交换机未收到ID为：{} 的消息，原因：{}", id, cause);
        }
    }

    /**
     *  可以在当消息传递过程中不可达目的地时将 消息返回给生产者
     *  只有路由没收到消息时，才进行回退
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {

        log.error("消息：{}，被交换机 {}退回，退回原因：{}，路由key：{}",
                returnedMessage.getMessage(), returnedMessage.getExchange(),
                        returnedMessage.getReplyText(), returnedMessage.getRoutingKey());
    }

}
