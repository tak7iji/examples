package org.sample.springmvc.extra;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.UserTransaction;

import org.sample.springmvc.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value="mb")
public class MessageBean {
    @Autowired JndiTemplate jndiTemplate;
    @Autowired JndiTemplate remoteJndiTemplate;
    @Autowired ConnectionFactory connectionFactory;
    
    private String message;

    public String getMessage() {
        return message;
    }

    @Transactional
    public void setMessage(String message) {
        this.message = "Hello, "+message;
        MessageSender sender = new MessageSender();
        
        try {
            System.out.println("ConnectionFactory: "+connectionFactory);
            Queue queue = jndiTemplate.lookup("queue/messageQueue", Queue.class);
            System.out.println("Queue: "+queue);
//            UserTransaction ut = jndiTemplate.lookup("java:jboss/UserTransaction", UserTransaction.class);

//            ut.begin();
            try {
                sender.setConnectionFactory(connectionFactory);
                sender.setQueue(queue);
                sender.simpleSend(this.message);
            } finally {
//                ut.commit();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
