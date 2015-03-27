package org.sample.jboss.jms;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JmsClient implements CommandLineRunner {
    private static final Logger log = Logger.getLogger(JmsClient.class.getName());

    @Autowired
    MessageSender messageSender;
    
    @Autowired
    MessageReceiver messageReceiver;
    
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(JmsClient.class, args);
        for(String name:ctx.getBeanDefinitionNames()){
            log.info("Bean name: "+name);
        }
        // アプリケーション終了
        ctx.close();
    }

    @Override
    public void run(String... arg0) throws Exception {
        log.info("Send message.");
        messageSender.simpleSend();
        messageReceiver.receiveMessage();
    }
}
