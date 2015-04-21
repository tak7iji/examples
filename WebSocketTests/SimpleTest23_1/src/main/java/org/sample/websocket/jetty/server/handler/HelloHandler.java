package org.sample.websocket.jetty.server.handler;

import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.sample.websocket.jetty.server.HelloSocket;

public class HelloHandler extends WebSocketHandler {

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.register(HelloSocket.class);
        
    }

}
