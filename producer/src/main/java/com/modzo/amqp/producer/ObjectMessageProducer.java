package com.modzo.amqp.producer;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.text.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
class ObjectMessageProducer {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectMessageProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public ObjectMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 100L)
    public void produce() {
        ObjectMessage objectMessage = new ObjectMessage(
                randomString(100),
                randomString(1000),
                new Date()
        );
        this.rabbitTemplate.convertAndSend(Queues.OBJECT, objectMessage);
        LOG.info("Send object message {}", objectMessage);
    }

    static class ObjectMessage {
        private final String type;
        private final String message;
        private final Date date;

        ObjectMessage(String type, String message, Date date) {
            this.type = type;
            this.message = message;
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public String getMessage() {
            return message;
        }

        public Date getDate() {
            return date;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("type", type)
                    .append("message", message)
                    .append("date", date)
                    .toString();
        }
    }

    private static String randomString(int length) {
        return new RandomStringGenerator.Builder().build().generate(length);
    }
}
