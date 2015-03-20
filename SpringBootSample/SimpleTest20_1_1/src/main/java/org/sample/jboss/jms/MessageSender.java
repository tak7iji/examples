package org.sample.jboss.jms;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    private Logger logger = Logger.getLogger(MessageSender.class);

    @Autowired private JmsTemplate jmsTemplate;

    public void simpleSend() {
        logger.info("Message send.");
        this.jmsTemplate.send("queue/messageQueue", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hello queue world");
            }
        });
    }
}
