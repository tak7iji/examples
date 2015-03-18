package org.sample.jboss.jms;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class JmsClient {
    private static final Logger log = Logger.getLogger(JmsClient.class.getName());
    
    public static void main(String[] args) throws Exception {
        Object[] objects = {MessageSender.class, MessageReceiver.class};
        ConfigurableApplicationContext ctx = SpringApplication.run(objects, args);
        // アプリケーション終了
        ctx.close();
    }
}
