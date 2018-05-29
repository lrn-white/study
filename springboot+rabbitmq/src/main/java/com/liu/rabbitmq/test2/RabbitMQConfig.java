package com.liu.rabbitmq.test2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 实现一对多即多个消费者消费同一个队列
 * @author 刘仁楠
 * @date 2018/5/28 14:47
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue workQueue(){
        return new Queue("work-queue");
    }

    @Bean
    public WorkReceiver workReceiver(){
        return new WorkReceiver("Receiver0");
    }

    @Bean
    public WorkReceiver workReceiver1() {
        return new WorkReceiver("Receiver1");
    }

    @Bean
    public WorkSend workSend() {
        return new WorkSend();
    }
}
