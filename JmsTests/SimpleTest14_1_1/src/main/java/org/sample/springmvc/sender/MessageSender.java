package org.sample.springmvc.sender;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender {
    private Queue queue;
    private ConnectionFactory connectionFactory;

    public void setConnectionFactory(ConnectionFactory cf) {
        this.connectionFactory = cf;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public void simpleSend(final String message) {
        try (Connection qc = connectionFactory.createConnection(); QueueSession session = (QueueSession) qc.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
            TextMessage textMessage = session.createTextMessage(message);
            
            QueueSender queueSender = session.createSender(queue);
            queueSender.send(textMessage);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
