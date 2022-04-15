package com.mq.top;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

//声明主题交换机  队列
public class Receive01 {

    //声明交换机名称
    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getCannel();
        //声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        //声明一个队列  ：Q1
        channel.queueDeclare("Q1", false, false, false, null);

        //绑定信道 规则                                 表示交换机传输信道规则：xxx.orange.xxx都会传输给此队列
        channel.queueBind("Q1", EXCHANGE_NAME, "*.orange.*");

        System.out.println("消费者C1 对应 队列 Q1，等待接受消息。。。");


        //接受消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接受的消息为：" + new String(message.getBody(), "UTF-8"));
        };
        channel.basicConsume("Q1", true, deliverCallback, consumerTag -> {});  //不写消费者取消消息时回调接口
    }
}
