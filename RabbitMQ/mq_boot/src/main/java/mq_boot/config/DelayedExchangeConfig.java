package mq_boot.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//延迟

@Configuration
public class DelayedExchangeConfig {

    //队列
    public static final String DELAYED_QUEUE = "delayed_queue";
    //交换机
    public static final String DELAYED_EXCHANGE = "delayed_exchange";
    //rountingKey
    public static final String DELAYED_ROUTINGKEY = "delayed_rountingKey";


    //声明交换机     基于直接类型的延迟交换机
    @Bean
    public CustomExchange delayedExchange(){
        Map<String, Object> map = new HashMap<>();
        map.put("x-delayed-type", "direct");

        /**
         *  1.交换机的名称
         *  2.交换机的类型
         *  3.是否需要持久化
         *  4.是否需要自动删除
         *  5.其他参数
         */
        return new CustomExchange(DELAYED_EXCHANGE, "x-delayed-message", true, false, map);
    }

    @Bean
    public Queue delayedQueue(){
        return new Queue(DELAYED_QUEUE);
    }

    //绑定
    @Bean
    public Binding delayedQueueBindingExchange(@Qualifier("delayedQueue") Queue delayedQueue,
                                               @Qualifier("delayedExchange") CustomExchange delayedExchange){

        return BindingBuilder.bind(delayedQueue).to(delayedExchange).with(DELAYED_ROUTINGKEY).noargs();
    }






}
