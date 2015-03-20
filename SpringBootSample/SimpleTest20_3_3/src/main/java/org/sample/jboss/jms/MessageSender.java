package org.sample.jboss.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    private Logger logger = Logger.getLogger(MessageSender.class);

//    @Autowired private JmsTemplate jmsTemplate;
    @Autowired private ConnectionFactory connectionFactory;
    
    public void simpleSend() throws Exception {
        // JBossEAP6のhornetq-server設定で、security-enabledをfalseにする場合
//      this.jmsTemplate.send("jms/queue/test", new MessageCreator() {
//      public Message createMessage(Session session) throws JMSException {
//          return session.createTextMessage("hello queue world");
//      }
//  });

        // JBossEAP6のhornetq-server設定で、security-enabledをtrue（デフォルトの動作）にする場合
        Connection connection = connectionFactory.createConnection("jboss", "jboss-eap6");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = (Queue) new InitialContext().lookup("jms/queue/test");
        connection.start();
        Message message = session.createTextMessage("hello queue world");
        session.createProducer(queue).send(message);
        connection.close();
        
    }
}
