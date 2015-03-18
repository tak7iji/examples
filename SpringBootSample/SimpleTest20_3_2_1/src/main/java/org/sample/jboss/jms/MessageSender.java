package org.sample.jboss.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

@SpringBootApplication
@Order(0)
public class MessageSender implements CommandLineRunner {
    private Logger logger = Logger.getLogger(MessageSender.class);

    @Autowired JmsTemplate jmsTemplate;
    @Autowired String messageQueue;

    @Override
    public void run(String... args) throws Exception {
        logger.info(messageQueue);
        this.jmsTemplate.send(messageQueue, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                logger.info("Message send.");
                return session.createTextMessage("hello queue world");
            }
        });
    }
}
