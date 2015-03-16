package org.sample.springmvc.config;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class WebAppInitializer {
    private Logger logger = Logger.getLogger(WebAppInitializer.class);
    
    public static void main(String[] args) {
        SpringApplication.run(WebAppInitializer.class, args);
    }
}
