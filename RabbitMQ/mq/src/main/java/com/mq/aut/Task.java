package com.mq.aut;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task {

    //队列名称
    public static final String TASK_NAME = "ack";

    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getCannel();

        //声明队列
        //需要队列进行持久化
        boolean durable = true;
        channel.queueDeclare(TASK_NAME, durable, false, false, null);

        //从控制台中输入信息
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String message = scanner.next();
            //设置生产者发送消息为持久化消息（要求保存在磁盘上）：MessageProperties.PERSISTENT_TEXT_PLAIN

            channel.basicPublish("", TASK_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息： " + message);
        }

    }
}
