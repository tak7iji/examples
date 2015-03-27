package org.sample.spring.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

@ServerEndpoint(value = "/wsdemo")
public class ServerEndpointSample {
    private Logger logger = Logger.getLogger(ServerEndpointSample.class);

    @OnMessage
    public String onMessage(String text) {
        logger.info("Received message: "+text);
        return text;
    }
}
