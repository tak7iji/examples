package org.sample.springmvc.extra;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.NamingException;

import org.sample.springmvc.sender.MessageSender;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Component;

@Component(value="mb")
public class MessageBean {
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Hello, "+message;
        MessageSender sender = new MessageSender();
        
        try {
            JndiTemplate jndiTemplate = new JndiTemplate();
            QueueConnectionFactory cf = jndiTemplate.lookup("java:/JmsXA", QueueConnectionFactory.class);
            System.out.println("ConnectionFactory: "+cf);
            Queue queue = jndiTemplate.lookup("queue/messageQueue", Queue.class);
            System.out.println("Queue: "+queue);

            sender.setConnectionFactory(cf);
            sender.setQueue(queue);
            sender.simpleSend(this.message);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
