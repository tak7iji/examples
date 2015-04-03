package org.sample.spring.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class EndpointConfig extends ServerEndpointConfig.Configurator {
    private Logger logger = Logger.getLogger(EndpointConfig.class);
    
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        logger.info(request);
        
        HttpSession httpSession = (HttpSession)request.getHttpSession();
        Assert.isInstanceOf(HttpSession.class, httpSession, "Can't get HttpSession.");
        
        httpSession.setAttribute("data", "foo");
    }
}
