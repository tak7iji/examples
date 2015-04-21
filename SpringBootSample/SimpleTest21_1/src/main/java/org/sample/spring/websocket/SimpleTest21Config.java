package org.sample.spring.websocket;

import javax.websocket.server.ServerEndpointConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class SimpleTest21Config {

    @Bean
    public ServerEndpointConfig serverEndpointConfig() {
        return ServerEndpointConfig.Builder.create(ServerEndpointSample.class, "/wsdemo").build();
    }
    
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
