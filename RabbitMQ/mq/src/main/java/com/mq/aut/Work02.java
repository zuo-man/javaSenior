package com.mq.aut;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

//接受二
//消息在手动应答时不丢失，放回队列中重新消费
public class Work02 {

    //队列名称
    public static final String TASK_NAME = "ack";

    //接受消息
    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getCannel();
        System.out.println("C2 等待接受消息处理时间较短");

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            //睡 30秒
            RabbitMqUtils.sleepUtils(30);
            System.out.println("接受的消息 ：" + new String(message.getBody(), "UTF-8"));

            /**
             * 手动应答
             * 1.消息的标记 tag
             * 2.是否批量应答 false：不批量应答信道中的消息 true：批量
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };

        //设置不公平分发，默认是0：公平分发
//        channel.basicQos(1);
        //设置预取值
        channel.basicQos(2);

        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume(TASK_NAME, autoAck, deliverCallback, (consumerTag -> {
            System.out.println(consumerTag + "消费者取消接受");
        }));
    }
}
