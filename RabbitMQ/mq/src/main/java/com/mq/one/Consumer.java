package com.mq.one;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

//消费者：接受消息
public class Consumer {

    //队列名称
    public static final String QUEUE_NAME = "hello";

    //发消息
    public static void main(String[] args) throws Exception {
        //创建一个工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂IP 连接RabbitMQ的队列
        factory.setHost("47.96.175.143");
        //用户名 密码
        factory.setUsername("admin");
        factory.setPassword("123");

        //创建连接
        Connection conn = factory.newConnection();

        //获取信道
        Channel channel = conn.createChannel();

        //声明 接受消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接受的消息为：" + new String(message.getBody()));
        };
        //取消消息时的回调
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消费消息被中断");
        };

        /**
         * 消费者接受消息
         * 1.消息哪个队列
         * 2.消费成功后是否要自动应答 true：代表自动应答  false：代表手动应答
         * 3.消费者未成功消费的回调
         * 4.消费者取录消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

    }
}
