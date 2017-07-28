package com.modzo.amqp.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloMessageProducer {
    private static final Logger LOG = LoggerFactory.getLogger(HelloMessageProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public HelloMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 100L)
    public void produce() {
        String message = String.format("Say hello at %s", new Date());
        this.rabbitTemplate.convertAndSend(Constants.HELLO, message);
        LOG.info("Send message: `{}`", message);
    }

}
