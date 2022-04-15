package com.mq.DeadLetter;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

//死信队列   生产者
public class Producer {

    //普通交换机
    public static final String NORMAL_EXCHANGE = "normal_exchange";

    public static void main(String[] args) throws Exception{
        Channel cannel = RabbitMqUtils.getCannel();

        //设置消息过期时间 TTL      1s = 1000ms
//        AMQP.BasicProperties build = new AMQP.BasicProperties().builder().expiration("1000").build();



        for(int i = 0; i < 10; i++){
            String message = "info" + i;
            cannel.basicPublish(NORMAL_EXCHANGE, "Simple", null, message.getBytes());
        }

    }

}
