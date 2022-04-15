package com.mq.Switch;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

//接受消息
public class Direct02 {

    //声明交换机名称
    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getCannel();
        //声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        //声明一个队列
        channel.queueDeclare("disk", false, false, false, null);

        //接受
        channel.queueBind("disk", EXCHANGE_NAME, "error");

        //接受消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接受的消息为：" + new String(message.getBody(), "UTF-8"));
        };
        channel.basicConsume("disk", true, deliverCallback, consumerTag -> {});  //不写消费者取消消息时回调接口

    }
}
