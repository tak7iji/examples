package org.sample.spring.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

@ServerEndpoint(value = "/wsdemo", configurator=EndpointConfig.class)
public class WebSocketSample {
    private Logger logger = Logger.getLogger(WebSocketSample.class);

    @OnMessage
    public String onMessage(String text) {
        logger.info("Received message: "+text);
        return text;
    }
}
