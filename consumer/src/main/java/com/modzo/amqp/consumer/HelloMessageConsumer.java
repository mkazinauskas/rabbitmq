package com.modzo.amqp.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

@RabbitListener(queues = Queues.HELLO)
@Component
class HelloMessageConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(HelloMessageConsumer.class);

    @RabbitHandler
    public void consume(@Payload String helloMessage) {
        LOG.info("Message: `{}` at `{}`", helloMessage, new Date());
    }
}

