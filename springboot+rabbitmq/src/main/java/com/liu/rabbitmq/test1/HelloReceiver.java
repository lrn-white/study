package com.liu.rabbitmq.test1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author 刘仁楠
 * @date 2018/5/28 14:25
 */
@Component
public class HelloReceiver {

    @RabbitListener(queues = "date")
    public void processDate(String date) {
        System.out.println("Receiver--------" + date);
    }

    @RabbitListener(queues = "object")
    public void processObj(User user) {
        System.out.println("Receiver ==================: " + user);
        System.out.println("Receiver ==================: " + user.getName());
        System.out.println("Receiver ==================: " + user.getSex());
    }
}
