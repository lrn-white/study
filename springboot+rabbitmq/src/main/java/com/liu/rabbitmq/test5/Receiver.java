package com.liu.rabbitmq.test5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 刘仁楠
 * @date 2018/5/28 17:04
 */
@Component(value = "t5Receiver")
public class Receiver {

    @RabbitListener(queues = "#{autoDeleteQueue0.name}")
    public void receiver0(String str) {
        System.out.println("receiver0++++++++++:" + str);
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
    }

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiver1(String str) {
        System.out.println("receiver1++++++++++:" + str);
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
    }
}
