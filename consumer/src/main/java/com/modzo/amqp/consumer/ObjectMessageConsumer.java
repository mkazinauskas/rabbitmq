package com.modzo.amqp.consumer;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

@RabbitListener(queues = ApplicationConstants.OBJECT)
@Component
public class ObjectMessageConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectMessageConsumer.class);

    @RabbitHandler
    public void consume(@Payload ObjectMessage message) {
        LOG.info("Message: `{}` at `{}`", message, new Date());
    }

    public static class ObjectMessage {
        private String type;
        private String message;
        private Date date;

        public ObjectMessage() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
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
}
