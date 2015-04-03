package org.sample.spring.websocket;

import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    @Bean
    public WebSocketSample websocketSample() {
        return new WebSocketSample();
    }
    
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
    
    @Bean
    public ServletListenerRegistrationBean<SessionCreateListener> sessionCreateListener() {
        return new ServletListenerRegistrationBean<SessionCreateListener>(new SessionCreateListener());
    }

}
