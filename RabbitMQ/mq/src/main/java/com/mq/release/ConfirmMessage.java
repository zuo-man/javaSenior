package com.mq.release;

import com.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

//测试发布确认
public class ConfirmMessage {

    //批量发消息的个数
    public static final int MESSAGE_COUNT = 100;

    public static void main(String[] args) throws Exception{
        //1.单个发布确认          发布100条单独确认消息，时间为：3525ms
//        ConfirmMessage.Individually();
        //2.批量发布确认          发布100条批量确认消息，时间为：79ms
//        ConfirmMessage.Batch();
        //3.异步发布确认          发布100条异步确认消息，时间为：19ms
        ConfirmMessage.Async();
    }

    //异步发布确认
    public static void Async() throws Exception{
        Channel channel = RabbitMqUtils.getCannel();
        //随机生成 队列的名称
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        //开启发布确认
        channel.confirmSelect();

        /**
         * 线程安全有序的一个哈希表，适用于高并发的情况下
         * 1.能将序号（key） 与 消息（map）进行关联
         * 2.只需要给出序号，批量删除条数
         * 3.支持高并发（多线程）
         */
        ConcurrentSkipListMap<Long, String> confirms = new ConcurrentSkipListMap<>();

        //消息确认成功 回调函数       deliveryTag：消息的标记值， multiple：是否为批量确认
        ConfirmCallback callback = (deliveryTag, multiple)->{
            if(multiple){
                // ②：删除已经确认的消息，剩下的就是未确认的消息
                ConcurrentNavigableMap<Long, String> confiredmap = confirms.headMap(deliveryTag, multiple);
                confiredmap.clear();
            }else {
                confirms.remove(deliveryTag);
            }
            System.out.println("成功确认");
        };
        //消息确认失败 回调函数           deliveryTag：消息的标记值， multiple：是否为批量确认
        ConfirmCallback nackCallback = (deliveryTag, multiple)->{
            // ③：打印未确认的消息
            String message = confirms.get(deliveryTag);
            System.out.println("未确认的消息标记值：" + deliveryTag + "，未确认消息是：" + message);
        };

        /**
         * 异步通知
         * 1.监听哪些消息成功了
         * 2.监听哪些消息失败了
         *      成功了的也可以写null
         */
        channel.addConfirmListener(callback, nackCallback);

        //开启时间
        long begin = System.currentTimeMillis();
        //批量发送消息
        for(int i = 0; i < MESSAGE_COUNT; i++){
            String message = "消息" + i;
            channel.basicPublish("", queueName, null, message.getBytes());

            // ①：此处记录下所有要发送的消息 消息总和         key为序号，value为消息
            confirms.put(channel.getNextPublishSeqNo(), message);
        }
        //结束时间
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "条异步确认消息，时间为：" + (end - begin) + "ms");
    }







    //单个确认
    public static void Individually() throws Exception{
        Channel channel = RabbitMqUtils.getCannel();
        //随机生成 队列的名称
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);

        //开启发布确认
        channel.confirmSelect();
        //开启时间
        long begin = System.currentTimeMillis();

        //批量发消息
        for(int i = 0; i < MESSAGE_COUNT; i++){
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            //单个消息就马上进行发布确认
            boolean flag = channel.waitForConfirms();
            if(flag){
                System.out.println("消息发送成功");
            }
        }

        //结束时间
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "条单独确认消息，时间为：" + (end - begin) + "ms");
    }


    //批量确认
    public static void Batch() throws Exception{
        Channel channel = RabbitMqUtils.getCannel();
        //随机生成 队列的名称
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);

        //开启发布确认
        channel.confirmSelect();
        //开启时间
        long begin = System.currentTimeMillis();

        //批量确认消息大小，多少条确认一次
        int batchSize = 50;

        //批量发消息
        for(int i = 0; i < MESSAGE_COUNT; i++){
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            //判断达到 50条数据时，批量确认一次
            if(i%batchSize == 0){
                //发布确认
                channel.waitForConfirms();
            }
        }

        //结束时间
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "条批量确认消息，时间为：" + (end - begin) + "ms");//发布100条确认消息，时间为：3525ms
    }


}
