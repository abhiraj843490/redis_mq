package com.redis.rabbit_mq.controller;

import com.redis.rabbit_mq.config.RabbitConfig;
import com.redis.rabbit_mq.model.MessageQ;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class RabbitController {
    @Autowired
    private RabbitTemplate template;
    @PostMapping("/publish")
    public MessageQ publishMessage(@RequestBody MessageQ messageQ){
        messageQ.setId(UUID.randomUUID().toString());
        messageQ.setMessageDate(new Date());
        template.convertAndSend(RabbitConfig.EXCHANGE,RabbitConfig.ROUTING, messageQ);
        return messageQ;
    }
}
