package com.mq.top;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

//声明主题交换机  队列
public class Receive02 {

    //声明交换机名称
    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getCannel();
        //声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        //声明一个队列  ：Q2
        channel.queueDeclare("Q2", false, false, false, null);

        //绑定信道 规则                     表示交换机传输信道规则：xxx.xxx.rabbit  都会传输给此队列
        channel.queueBind("Q2", EXCHANGE_NAME, "*.*.rabbit");
        //绑定信道 规则                     表示交换机传输信道规则：lazy.xxxx.xxx.x.xxx.xx等 都会传输给此队列
        channel.queueBind("Q2", EXCHANGE_NAME, "lazy.#");

        System.out.println("消费者C2 对应 队列 Q2，等待接受消息。。。");


        //接受消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接受的消息为：" + new String(message.getBody(), "UTF-8"));
        };
        channel.basicConsume("Q2", true, deliverCallback, consumerTag -> {});  //不写消费者取消消息时回调接口
    }
}
