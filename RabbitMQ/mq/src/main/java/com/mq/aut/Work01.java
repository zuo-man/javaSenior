package com.mq.aut;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

//接受一
//消息在手动应答时不丢失，放回队列中重新消费
public class Work01 {

    //队列名称
    public static final String TASK_NAME = "ack";

    //接受消息
    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getCannel();
        System.out.println("C1 等待接受消息处理时间较短");

        DeliverCallback deliverCallback = (consum3erTag, message) -> {
            //睡 1秒
            RabbitMqUtils.sleepUtils(1);
            System.out.println("接受的消息 ：" + new String(message.getBody(), "UTF-8"));

            /**
             * 手动应答：basicAck：  用于肯定确认，MQ已经知道该消息接受并处理了，可以将其丢弃
             * 1.消息的标记 tag
             * 2.是否批量应答         false：不批量应答信道中的消息       true：批量
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };

        //设置不公平分发：1 ，默认是0：公平分发
//        channel.basicQos(1);
        //设置预取值
        channel.basicQos(3);

        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume(TASK_NAME, autoAck, deliverCallback, (consumerTag -> {
            System.out.println(consumerTag + "消费者取消接受");
        }));
    }
}
