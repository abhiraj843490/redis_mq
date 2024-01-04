package com.redis.rabbit_mq.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE = "rabbit_queue";
    public static final String EXCHANGE = "Exchanger";
    public static final String ROUTING = "message_routingKey";
    @Bean
   public Queue rabbitQ(){
       return new Queue(QUEUE);
   }
   @Bean
   public TopicExchange topicExchange(){
       return new TopicExchange(EXCHANGE);
   }

    /**
     * this method is used to bind the particular queue to exchange with routing key
     * @param queue
     * @param topicExchange
     * @return
     */
    @Bean
   public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue)
                .to(topicExchange)
                .with(ROUTING);
   }
   @Bean
   public MessageConverter messageConverter(){
       return new Jackson2JsonMessageConverter();
   }
   @Bean
   public AmqpTemplate rabbit_template(ConnectionFactory connectionFactory){
       RabbitTemplate template = new RabbitTemplate(connectionFactory);
       template.setMessageConverter(messageConverter());
       return template;
   }
}
