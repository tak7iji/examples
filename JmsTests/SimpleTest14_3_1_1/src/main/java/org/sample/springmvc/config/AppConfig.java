package org.sample.springmvc.config;

import javax.jms.ConnectionFactory;
import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.destination.JndiDestinationResolver;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@EnableJms
@EnableTransactionManagement
@ComponentScan(basePackages={"org.sample.springmvc"})
public class AppConfig {
    @Bean
    public JndiTemplate jndiTemplate() {
        return new JndiTemplate();
    }
    
    @Bean
    public ConnectionFactory connectionFactory() throws NamingException {
        return jndiTemplate().lookup("java:/JmsXA", ConnectionFactory.class);
    }
    
    @Bean
    public JndiDestinationResolver destinationResolver() {
        JndiDestinationResolver destinationResolver = new JndiDestinationResolver();
        destinationResolver.setJndiTemplate(jndiTemplate());
        return destinationResolver;
    }
    
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() throws NamingException {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConcurrency("1");
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        jmsListenerContainerFactory.setDestinationResolver(destinationResolver());
        return jmsListenerContainerFactory;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JtaTransactionManager();
    }
}
