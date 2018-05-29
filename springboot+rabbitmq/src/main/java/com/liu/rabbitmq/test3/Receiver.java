package com.liu.rabbitmq.test3;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收广播的消息
 * @author 刘仁楠
 * @date 2018/5/28 16:23
 */
@Component
public class Receiver {

    @RabbitListener(queues = "#{autoDeleteQueue0.name}")
    public void receiver0(String str) {
        System.out.println("receiver0++++++++++:" + str);
    }

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiver1(String str) {
        System.out.println("receiver1++++++++++:" + str);
    }
}
