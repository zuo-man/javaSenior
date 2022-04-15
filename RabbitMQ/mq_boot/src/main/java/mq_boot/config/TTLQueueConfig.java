package mq_boot.config;

//TTL 队列  配置文件类

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TTLQueueConfig {

    //普通交换机
    public static final String X_EXCHANGE = "X";
    //普通队列
    public static final String QUEUE_A = "QA";
    public static final String QUEUE_B = "QB";
    //死信交换机
    public static final String DIE_EXCHANGE = "DIE";
    //死信队列
    public static final String DEAD_QUEUE = "QD";


    //普通队列
    public static final String QUEUE_T = "QT";

    //声明X_Exchange 别名
    @Bean("XExchange")
    public DirectExchange XExchange(){
        return new DirectExchange(X_EXCHANGE);
    }
    //声明DIE_Exchange 别名
    @Bean("DieExchange")
    public DirectExchange DieExchange(){
        return new DirectExchange(DIE_EXCHANGE);
    }


    //声明普通队列 QT
    @Bean("queueT")
    public Queue queueT(){
        Map<String, Object> map = new HashMap<>(3);
        //设置死信交换机
        map.put("x-dead-letter-exchange", DIE_EXCHANGE);
        //设置死信RountingKey
        map.put("x-dead-letter-routing-key", "DieKey");

        return QueueBuilder.durable(QUEUE_T).withArguments(map).build();
    }

    //声明普通队列TTL 为 10s
    @Bean("queueA")
    public Queue queueA(){
        Map<String, Object> map = new HashMap<>(3);
        //设置死信交换机
        map.put("x-dead-letter-exchange", DIE_EXCHANGE);
        //设置死信RountingKey
        map.put("x-dead-letter-routing-key", "DieKey");
        //设置TTl  单位：ms      5s
        map.put("x-message-ttl", 5000);

        return QueueBuilder.durable(QUEUE_A).withArguments(map).build();
    }
    //声明普通队列TTL 为 10s
    @Bean("queueB")
    public Queue queueB(){
        Map<String, Object> map = new HashMap<>(3);
        //设置死信交换机
        map.put("x-dead-letter-exchange", DIE_EXCHANGE);
        //设置死信RountingKey
        map.put("x-dead-letter-routing-key", "DieKey");
        //设置TTl  单位：ms        20s
        map.put("x-message-ttl", 20000);

        return QueueBuilder.durable(QUEUE_B).withArguments(map).build();
    }

    //死信队列
    @Bean("queueQD")
    public Queue queueQD(){
        return QueueBuilder.durable(DEAD_QUEUE).build();
    }

    //绑定
    @Bean
    public Binding queueBBindingT(@Qualifier("queueT") Queue queueB,
                                  @Qualifier("XExchange") DirectExchange XExchange){

        return BindingBuilder.bind(queueB).to(XExchange).with("TKey");
    }
    @Bean
    public Binding queueABindingX(@Qualifier("queueA") Queue queueA,
                                  @Qualifier("XExchange") DirectExchange XExchange){

        return BindingBuilder.bind(queueA).to(XExchange).with("XA");
    }
    @Bean
    public Binding queueBBindingX(@Qualifier("queueB") Queue queueB,
                                  @Qualifier("XExchange") DirectExchange XExchange){

        return BindingBuilder.bind(queueB).to(XExchange).with("XB");
    }
    @Bean
    public Binding queueQDBindingX(@Qualifier("queueQD") Queue queueQD,
                                  @Qualifier("DieExchange") DirectExchange DieExchange){

        return BindingBuilder.bind(queueQD).to(DieExchange).with("DieKey");
    }





}
