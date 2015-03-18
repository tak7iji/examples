package org.sample.jboss.jms;

import javax.jms.Message;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@Order(1)
public class MessageReceiver implements CommandLineRunner {
    private Logger logger = Logger.getLogger(MessageReceiver.class);

    @Autowired JmsTemplate jmsTemplate;
    @Autowired String messageQueue;

    @Override
    public void run(String... args) throws Exception {
        Message message = this.jmsTemplate.receive(messageQueue);
        logger.info("Message: "+message.getBody(String.class));
    }
}
