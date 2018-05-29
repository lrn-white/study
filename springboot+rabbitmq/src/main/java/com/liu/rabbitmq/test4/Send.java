package com.liu.rabbitmq.test4;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 刘仁楠
 * @date 2018/5/28 16:46
 */
@Component(value = "t4Send")
public class Send {

    @Autowired
    private DirectExchange directExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String[] keys = {"orange", "black", "green"};

    /**
     * 如果是keys[0]那么只有receiver0，
     * 如果是keys[1]那么就是类似广播那样，有receive0和receive1，
     * 如果是keys[2]那么只有receive1
     * @author 刘仁楠
     * @date 2018/5/28 16:48
     */
    public void send() {
        String message = "哈哈哈";
        for (int i = 0; i < 5; i++) {
            System.out.println("send++++++++++:".concat(message));
            rabbitTemplate.convertAndSend(directExchange.getName(), keys[2], message);
        }
    }
}
