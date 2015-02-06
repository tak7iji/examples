package org.sample.springmvc.receiver;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.sample.springmvc.sender.MessageSender;

public class MessageReceiver {
    private static Logger log = Logger.getLogger(MessageSender.class);

    private Queue queue;
    private QueueConnectionFactory connectionFactory;

    public void setConnectionFactory(QueueConnectionFactory cf) {
        this.connectionFactory = cf;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public String simpleReceive() {
        try (QueueConnection qc = connectionFactory.createQueueConnection(); 
                QueueSession session = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE)) {
            QueueReceiver queueReceiver = session.createReceiver(queue);
            qc.start();
            TextMessage message = (TextMessage) queueReceiver.receive(5000);
            return message.getText();
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
        return "No Message";
    }

}
