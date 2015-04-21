package org.sample.websocket.jetty.server;

import java.util.Collections;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class HelloSocketConfig implements ServerApplicationConfig {

    public Set<ServerEndpointConfig> getEndpointConfigs(
            Set<Class<? extends Endpoint>> endpointClasses) {
        ServerEndpointConfig config = null;
        for(Class<?> clazz : endpointClasses) {
            if (HelloSocket.class.isAssignableFrom(clazz)) {
                config = ServerEndpointConfig.Builder.create(HelloSocket.class, "/hellohandler").build();
            }
        }
        
        return Collections.singleton(config);
    }

    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        return null;
    }

}
