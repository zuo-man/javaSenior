package com.mq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;

//生成者：传输消息
public class Producer {

    //队列名称
    public static final String QUEUE_NAME = "hello";

    //发消息
    public static void main(String[] args) throws Exception{
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

        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化（硬盘） 默认情况存储在内存中
         * 3.该队列是否只供一个消费者进行消费  是否进行消息共享， true可以多个消费者消费  false：只能一个消费者消费
         * 4.是否自动删除，最后一个消费者端开连接后， 该队列是否自动删除 true：自动删除  false：不自动删除
         * 5.其他参数
         */
        Map<String, Object> map = new HashMap<>();
        //设置队列消费 优先级
        // 0 ~ 255  此处设置为 10，不要设置太大
        map.put("x-max-priority", 10);
        channel.queueDeclare(QUEUE_NAME, false, false, false, map);
        //发消息
        String message = "hello RABBIT 🐇";

        /**
         * 发送一个消息
         * 1.发送到哪个交换机
         * 2.路由的 Key值是哪个，本次是队列的名称
         * 3.其他参数
         * 4.发送消息的消息体
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        System.out.println("发送完毕...");
    }
}
