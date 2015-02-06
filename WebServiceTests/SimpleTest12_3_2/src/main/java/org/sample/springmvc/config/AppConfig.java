package org.sample.springmvc.config;

import org.apache.log4j.Logger;
import org.sample.springmvc.extra.MessageBean;
import org.sample.springmvc.extra.MessageBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"org.sample.springmvc.extra"})
public class AppConfig {
    private static Logger log = Logger.getLogger(AppConfig.class);

    @Bean
    public MessageBean messageBean() throws Exception {
        log.info("Get MessageBean");
        MessageBeanFactory mbf = new MessageBeanFactory();
        return mbf.getObject();
    }
}