package org.sample.jboss.jms;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    private Logger logger = Logger.getLogger(MessageReceiver.class);
    
    @Autowired private JmsTemplate jmsTemplate;

    public void receiveMessage() throws JMSException {
        Message message = this.jmsTemplate.receive("queue/messageQueue");
        logger.info("Message: "+message.getBody(String.class));
    }
    

}
