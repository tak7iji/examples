package org.sample.jboss.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MessageSender {
    private Logger logger = Logger.getLogger(MessageSender.class);

    @Autowired private JmsTemplate jmsTemplate;
    @Autowired PlatformTransactionManager transactionManager;
    @Autowired ConnectionFactory connectionFactory;

    @Transactional
    public void simpleSend() {
        logger.info("TransactionManager: "+transactionManager);
        logger.info("ConnectionFactory: "+connectionFactory);
        this.jmsTemplate.send("queue/messageQueue", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hello queue world");
            }
        });
    }
}
