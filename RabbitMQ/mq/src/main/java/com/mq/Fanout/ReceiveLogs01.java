package com.mq.Fanout;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

//消息接受
public class ReceiveLogs01 {

    //声明交换机名称
    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getCannel();
        //声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        /**
         * 生成一个临时队列、 队列名称随机
         * 当消费者断开与队列的连接时，队列自动删除
         */
        String queue = channel.queueDeclare().getQueue();
        /**
         * 绑定 交换机 队列
         */
        channel.queueBind(queue, EXCHANGE_NAME, "");
        System.out.println("C1 等待接受消息，把接受的消息打印在屏幕上。。。。");

        //接受消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接受的消息为：" + new String(message.getBody(), "UTF-8"));
        };
        channel.basicConsume(queue, true, deliverCallback, consumerTag -> {});  //不写消费者取消消息时回调接口

    }
}
