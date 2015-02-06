package org.sample.springmvc.extra;

import java.io.PrintWriter;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;
import org.sample.springmvc.receiver.MessageReceiver;
import org.sample.springmvc.sender.MessageSender;

@WebServlet(urlPatterns={"/view"})
public class HelloWorld extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(HelloWorld.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        String message = "Hello World";
        MessageSender sender = new MessageSender();
        MessageReceiver receiver = new MessageReceiver();
        
        try {
            InitialContext context = new InitialContext();
            QueueConnectionFactory cf = (QueueConnectionFactory) context.lookup("java:/JmsXA");
            log.info("ConnectionFactory: "+cf);
            
            Queue queue = (Queue) context.lookup("queue/messageQueue");
            log.info("Queue: "+queue);
            
            UserTransaction ut = (UserTransaction) context.lookup("java:jboss/UserTransaction");
            ut.begin();
            try {
                sender.setConnectionFactory(cf);
                sender.setQueue(queue);
                sender.simpleSend(message);
            } finally {
                ut.commit();
            }
            
            ut.begin();
            try {
                receiver.setConnectionFactory(cf);
                receiver.setQueue(queue);
                receiver.simpleReceive();

                PrintWriter writer = res.getWriter();
                writer.println(message);
                writer.flush();
                writer.close();
            } finally {
                ut.commit();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}