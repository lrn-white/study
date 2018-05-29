package com.liu.rabbitmq;

import com.liu.rabbitmq.test2.WorkSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 刘仁楠
 * @date 2018/5/28 15:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests2 {

    @Autowired
    private WorkSend workSend;

    @Test
    public void send() throws Exception {
        workSend.send();
    }
}
