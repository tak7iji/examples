package org.sample.springmvc.extra;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.sample.springmvc.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Component;

@Component(value="mb")
public class MessageBean {
    @Autowired JndiTemplate jndiTemplate;
    @Autowired JndiTemplate remoteJndiTemplate;
    @Autowired ConnectionFactory connectionFactory;
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Hello, "+message;
        MessageSender sender = new MessageSender();
        
        try {
//            QueueConnectionFactory cf = jndiTemplate.lookup("java:/ConnectionFactory", QueueConnectionFactory.class);
            System.out.println("ConnectionFactory: "+connectionFactory);
            Queue queue = jndiTemplate.lookup("queue/messageQueue", Queue.class);
            System.out.println("Queue: "+queue);

            sender.setConnectionFactory(connectionFactory);
            sender.setQueue(queue);
            sender.simpleSend(this.message);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
