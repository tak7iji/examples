package org.sample.jboss.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    @Autowired Environment environment;
    
    @Bean
    public String messageQueue() {
        return environment.getProperty("spring.hornetq.embedded.queues");
    }
}
