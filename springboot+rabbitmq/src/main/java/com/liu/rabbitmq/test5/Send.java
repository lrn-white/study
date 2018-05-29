package com.liu.rabbitmq.test5;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 刘仁楠
 * @date 2018/5/28 17:05
 */
@Component(value = "t5Send")
public class Send {

    @Autowired
    private TopicExchange topicExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String[] keys = {"quick.orange.rabbit",
            "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};

    public void send() {
        String message = "哈哈哈";
        for (int i = 0; i < 5; i++) {
            System.out.println("send++++++++++:".concat(message));
            rabbitTemplate.convertAndSend(topicExchange.getName(), keys[5], message);
        }
    }
}
