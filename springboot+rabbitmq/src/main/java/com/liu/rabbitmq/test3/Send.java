package com.liu.rabbitmq.test3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 广播消息
 * @author 刘仁楠
 * @date 2018/5/28 16:25
 */
@Component
public class Send {

    @Autowired
    private FanoutExchange fanoutExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", "哈哈哈");
        }
    }
}
