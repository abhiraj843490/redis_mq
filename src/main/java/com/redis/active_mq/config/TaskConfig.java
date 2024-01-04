//package com.redis.active_mq.config;
//
//import jakarta.jms.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Value;
//
//import org.springframework.jms.core.JmsTemplate;
//
//@EnableScheduling
//@Configuration
//public class TaskConfig {
//    @Value("${activemq.broker-url}")
//    private String brokerUrl;
//
//    @Bean
//    public Queue queue() {
//        return new ActiveMQQueue("standalone.queue");
//    }
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory() {
//        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
//        factory.setBrokerURL(brokerUrl);
//        return factory;
//    }
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        return new JmsTemplate(activeMQConnectionFactory());
//    }
//}
