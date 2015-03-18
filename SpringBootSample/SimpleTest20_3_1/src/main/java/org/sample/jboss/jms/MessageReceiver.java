package org.sample.jboss.jms;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MessageReceiver {
    private Logger logger = Logger.getLogger(MessageReceiver.class);
    
    @JmsListener(destination="queue/messageQueue")
    public void receiveMessage(String content) {
        logger.info("Message: "+content);
    }
    

}
