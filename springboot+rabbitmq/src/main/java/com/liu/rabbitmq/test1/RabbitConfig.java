package com.liu.rabbitmq.test1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 简单的实现配置两个队列
 * @author 刘仁楠
 * @date 2018/5/28 14:14
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue dateQueue(){
        return new Queue("date");
    }

    @Bean
    public Queue objQueue() {
        return new Queue("object");
    }
}
