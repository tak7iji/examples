package org.sample.jboss.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    private Logger logger = Logger.getLogger(MessageReceiver.class);
    
//  @Autowired private JmsTemplate jmsTemplate;
    @Autowired private ConnectionFactory connectionFactory;

    public void receiveMessage() throws Exception {
        // JBossEAP6のhornetq-server設定で、security-enabledをfalseにする場合
//        Object message = this.jmsTemplate.receiveAndConvert("jms/queue/test");
        
        // JBossEAP6のhornetq-server設定で、security-enabledをtrue（デフォルトの動作）にする場合
        Connection connection = connectionFactory.createConnection("jboss", "jboss-eap6");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = (Queue) new InitialContext().lookup("jms/queue/test");
        connection.start();
        TextMessage message = (TextMessage) session.createConsumer(queue).receive();
        connection.close();
        
        logger.info("Message: "+message.getText());
    }
    

}
