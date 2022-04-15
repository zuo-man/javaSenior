package mq_boot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//配置类  发布确认（高级）
@Configuration
public class ConfirmConfig {

    //队列
    public static final String CONFIRM_QUEUE = "confirm_queue";
    //交换机
    public static final String CONFIRM_EXCHANGE = "confirm_exchange";
    //rountingKey
    public static final String CONFIRM_ROUTINGKEY = "confirm_rountingKey";

    //备份交换机
    public static final String BACKUP_EXCHANGE = "backup_exchange";
    //备份队列
    public static final String BACKUP_QUEUE = "confirm_queue";
    //报警队列
    public static final String WARNING_QUEUE = "warning_queue";


    //声明交换机
    @Bean("confirmExchange")
    public DirectExchange confirmExchange(){
        return ExchangeBuilder.directExchange(CONFIRM_EXCHANGE).durable(true)
                .withArgument("alternage-exchange", BACKUP_EXCHANGE).build();
    }
    @Bean("confirmQueue")
    public Queue confirmQueue(){
//        return new Queue(CONFIRM_QUEUE);    //或者写成构建
        return QueueBuilder.durable(CONFIRM_QUEUE).build();
    }

    //绑定
    @Bean
    public Binding queueBindingExchange(@Qualifier("confirmQueue") Queue confirmQueue,
                                        @Qualifier("confirmExchange") DirectExchange confirmExchange){
        return BindingBuilder.bind(confirmQueue).to(confirmExchange).with(CONFIRM_ROUTINGKEY);
    }


    //备份交换机
    @Bean("backupExchange")
    public FanoutExchange backupExchange(){
        return new FanoutExchange(BACKUP_EXCHANGE);
    }
    @Bean("backupQueue")
    public Queue backupQueue(){
        return QueueBuilder.durable(BACKUP_QUEUE).build();
    }
    @Bean("warningQueue")
    public Queue warningQueue(){
        return QueueBuilder.durable(WARNING_QUEUE).build();
    }

    //绑定
    @Bean
    public Binding backupBindingBackupExchange(@Qualifier("backupQueue") Queue backupQueue,
                                               @Qualifier("backupExchange") FanoutExchange backupExchange){

        return BindingBuilder.bind(backupQueue).to(backupExchange);
    }
    @Bean
    public Binding warningBindingBackupExchange(@Qualifier("warningQueue") Queue warningQueue,
                                               @Qualifier("backupExchange") FanoutExchange backupExchange){

        return BindingBuilder.bind(warningQueue).to(backupExchange);
    }


}
