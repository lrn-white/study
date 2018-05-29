package com.liu.rabbitmq.test3;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.text.bidi.BidiLine;

/**
 * 发布与订阅的实现使用交换器类型为fanout
 *
 * @author 刘仁楠
 * @date 2018/5/28 16:16
 */
@Configuration
public class Config {

    /**
     * 定义扇出（广播）交换器
     *
     * @author 刘仁楠
     * @date 2018/5/28 16:20
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    /**
     * AnonymousQueue这个类是代表一个匿名的、不耐用的、独占的、自动删除的队列
     *
     * @author 刘仁楠
     * @date 2018/5/28 16:19
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
     * Binding这个类是一个简单的容器，用来搜集信息并描述绑定。
     * 把队列绑定到扇出（广播）交换器
     *
     * @author 刘仁楠
     * @date 2018/5/28 16:21
     */
    @Bean
    public Binding binding0(FanoutExchange fanoutExchange, Queue autoDeleteQueue0) {
        return BindingBuilder.bind(autoDeleteQueue0).to(fanoutExchange);
    }

    @Bean
    public Binding binding1(FanoutExchange fanoutExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(fanoutExchange);
    }
}
