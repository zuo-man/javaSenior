package com.mq.DeadLetter;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;


import java.util.HashMap;
import java.util.Map;

//死信队列  消费者01
public class Consumer01 {

    //普通交换机
    public static final String NORMAL_EXCHANGE = "normal_exchange";
    //死信交换机
    public static final String DEAD_EXCHANGE = "dead_exchange";
    //普通队列
    public static final String NORMAL_QUEUE = "normal_queue";
    //死信队列
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception{

        Channel channel = RabbitMqUtils.getCannel();
        //声明死信和普通交换机 类型为direct
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);

        Map<String, Object> arguments = new HashMap<>();
        //过期时间              1s = 1000ms         ，也可以在生成方设置过期时间
//        arguments.put("X-message-ttl", 100000);
        //正常队列设置死信交换机
        arguments.put("X-dead-letter-exchange", DEAD_EXCHANGE);

        //设置死信 RoutingKey
        arguments.put("X-dead-letter-rounting-key", "DeadKey");

        //设置正常队列的长度限制
        arguments.put("X-max-length", 5);
        //声明普通队列
        channel.queueDeclare(NORMAL_QUEUE, false, false, false, arguments);

        ////////////////////////////////////////////
        //声明死信队列
        channel.queueDeclare(DEAD_QUEUE, false, false, false, null);

        //绑定普通交换机 与普通队列
        channel.queueBind(NORMAL_QUEUE, NORMAL_EXCHANGE, "Simple");

        //绑定死信的交换机 与死信队列
        channel.queueBind(DEAD_QUEUE, DEAD_EXCHANGE, "DeadKey");

        System.out.println("Consumer 01 等待接受消息。。。");
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String massage = new String(message.getBody(), "UTF-8");
            //拒绝消息的消息 转到死信
            if(message.equals("info5")){
                System.out.println("Consumer01 拒绝的消息是：" + message + "：此消息被拒");
                channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
            }else {
                System.out.println("Consumer01接受消息：" + message);
                channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
            }
        };
        //开启手动应答
        channel.basicConsume(NORMAL_QUEUE, false, deliverCallback, consumerTag -> {});  //不写消费者取消消息时回调接口
    }

}
