package org.sample.springmvc.extra;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.sample.springmvc.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Component(value="mb")
public class MessageBean {
    @Autowired JndiTemplate jndiTemplate;
    @Autowired JndiTemplate remoteJndiTemplate;
    @Autowired ConnectionFactory connectionFactory;
    @Autowired PlatformTransactionManager transactionManager;
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Hello, "+message;
        MessageSender sender = new MessageSender();
        
        try {
            System.out.println("ConnectionFactory: "+connectionFactory);
            Queue queue = jndiTemplate.lookup("queue/messageQueue", Queue.class);
            System.out.println("Queue: "+queue);
            final String msg = message;

            new TransactionTemplate(transactionManager).execute(new TransactionCallback<Object>() {
                @Override
                public Object doInTransaction(TransactionStatus status) {
                    sender.setConnectionFactory(connectionFactory);
                    sender.setQueue(queue);
                    sender.simpleSend(msg);
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
