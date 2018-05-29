package com.liu.rabbitmq.test2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 刘仁楠
 * @date 2018/5/28 14:50
 */
@Component
public class WorkReceiver {

    private String receiverInstance;

    public WorkReceiver(String receiverInstance) {
        this.receiverInstance = receiverInstance;
    }

    @RabbitListener(queues = "work-queue")
    public void receive(String str) {
        System.out.println(receiverInstance.concat("======: " + str));
    }
}
