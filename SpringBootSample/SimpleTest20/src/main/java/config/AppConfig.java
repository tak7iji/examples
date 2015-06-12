package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import demo.beans.MessageBean;

@Configuration
@ImportResource("classpath:META-INF/spring/context.xml")
//@PropertySource(value = { "classpath:META-INF/spring/messages.properties" })
public class AppConfig {
    @Value(value = "${message.text}")
    private String message;
    
    @Value(value = "${spring.text}")
    private String spring;
    
    @Bean
    public MessageBean messageBean() {
        MessageBean mb = new MessageBean();
        mb.setMessage(spring + ": " + message);
        return mb;
    }

}
