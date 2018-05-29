package com.liu.rabbitmq.test4;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘仁楠
 * @date 2018/5/28 16:43
 */
@Configuration(value = "t4Config")
public class Config {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct-exchange");
    }

    /**
     * 定义自动删除匿名队列
     *
     * @author 刘仁楠
     * @date 2018/5/28 16:43
     */
    @Bean
    public Queue autoDeleteQueue0() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    /**
     * 绑定使用路由键为 orange 的 autoDeleteQueue0 队列到直连交换器上
     *
     * @author 刘仁楠
     * @date 2018/5/28 16:44
     */
    @Bean
    public Binding binding0a(DirectExchange directExchange, Queue autoDeleteQueue0) {
        return BindingBuilder.bind(autoDeleteQueue0).to(directExchange).with("orange");
    }

    @Bean
    public Binding binding0b(DirectExchange directExchange, Queue autoDeleteQueue0) {
        return BindingBuilder.bind(autoDeleteQueue0).to(directExchange).with("black");
    }

    @Bean
    public Binding binding1a(DirectExchange directExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(directExchange).with("black");
    }

    @Bean
    public Binding binding1b(DirectExchange directExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(directExchange).with("green");
    }

}
