package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.beans.MessageBean;

@Configuration
public class AppConfig {
    @Bean
    public MessageBean messageBean() {
        MessageBean mb = new MessageBean();
        mb.setMessage("Spring Boot");
        return mb;
    }

}
