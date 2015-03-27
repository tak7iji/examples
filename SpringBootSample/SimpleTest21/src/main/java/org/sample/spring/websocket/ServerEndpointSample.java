package org.sample.spring.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/wsdemo")
public class ServerEndpointSample {

    @OnMessage
    public String onMessage(String text) {
        System.out.println("Received message: "+text);
        return text;
    }
}
