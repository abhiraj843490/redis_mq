package com.redis.rabbit_mq.config;

import com.redis.rabbit_mq.model.MessageQ;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void listener(MessageQ messageQ){
        System.out.println("Receiving the message "+messageQ);
    }
}
