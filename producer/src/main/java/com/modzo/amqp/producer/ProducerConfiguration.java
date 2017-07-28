package com.modzo.amqp.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProducerConfiguration {
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue helloQueue() {
        return new Queue(Constants.HELLO, true);
    }

    @Bean
    public Queue objectQueue() {
       return new Queue(Constants.OBJECT, true);
    }

}
