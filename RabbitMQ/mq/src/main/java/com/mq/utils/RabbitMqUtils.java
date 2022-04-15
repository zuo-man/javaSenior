package com.mq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

//连接工厂创建信道工具类
public class RabbitMqUtils {

    public static Channel getCannel() throws Exception{
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

        return channel;
    }

    //线程等待
    public static void sleepUtils(int second){
        try{
            Thread.sleep(1000 * second);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
