package org.sample.springmvc.sender;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

public class MessageSender {
    private static Logger log = Logger.getLogger(MessageSender.class);

    private Queue queue;
    private QueueConnectionFactory connectionFactory;

    public void setConnectionFactory(QueueConnectionFactory cf) {
        this.connectionFactory = cf;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public void simpleSend(final String message) {
        try (QueueConnection qc = connectionFactory.createQueueConnection(); 
                QueueSession session = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE)) {
            TextMessage textMessage = session.createTextMessage(message);
            
            QueueSender queueSender = session.createSender(queue);
            queueSender.send(textMessage);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
