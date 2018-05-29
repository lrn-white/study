package com.liu.rabbitmq;

import com.liu.rabbitmq.test3.Send;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 刘仁楠
 * @date 2018/5/28 16:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests3 {

    @Autowired
    private Send send;

    @Test
    public void send() throws Exception {
        send.send();
    }
}
