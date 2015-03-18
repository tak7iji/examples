package org.sample.jboss.jms;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableTransactionManagement
@SpringBootApplication
public class JmsClient {
    private static final Logger log = Logger.getLogger(JmsClient.class.getName());

    @Autowired
    MessageSender messageSender;
    
    @RequestMapping("/send")
    @ResponseBody
    public String sendMessage() {
        messageSender.simpleSend();
        return "Send!";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(JmsClient.class, args);
    }
}
