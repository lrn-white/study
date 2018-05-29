package com.liu.rabbitmq.test1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生产者
 * @author 刘仁楠
 * @date 2018/5/28 14:16
 */
@Component
public class HelloSender {

    @Autowired
    private Queue dateQueue;

    @Autowired
    private Queue objQueue;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "now date ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date()));
        System.out.println("Sender:" + context);
        rabbitTemplate.convertAndSend(dateQueue.getName(), context);
    }

    public void sendObj(User user) {
        System.out.println("Sender : " + user);
        rabbitTemplate.convertAndSend(objQueue.getName(), user);
    }
}
