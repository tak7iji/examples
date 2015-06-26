package org.sample.spring.boot.prop;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PropProperties.class)
public class PropAutoConfiguration {

    @Bean
    public PropProperties propProperties() {
        return new PropProperties();
    }
}
