package com.liu.rabbitmq.test5;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘仁楠
 * @date 2018/5/28 17:02
 */
@Configuration(value = "t5Config")
public class Config {

    /**
     * 定义主题交换器
     * @author 刘仁楠
     * @date 2018/5/28 17:03
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    public Queue autoDeleteQueue0() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    /**
     * 绑定使用路由键为 orange 的 autoDeleteQueue0 队列到主题交换器上
     * @author 刘仁楠
     * @date 2018/5/28 17:03
     */
    @Bean
    public Binding binding0a(TopicExchange topicExchange, Queue autoDeleteQueue0) {
        return BindingBuilder.bind(autoDeleteQueue0).to(topicExchange).with("*.orange.*");
    }

    @Bean
    public Binding binding1a(TopicExchange topicExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(topicExchange).with("*.*.rabbit");
    }

    @Bean
    public Binding binding1b(TopicExchange topicExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(topicExchange).with("lazy.#");
    }
}
