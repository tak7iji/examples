package org.sample.websocket.jetty.server.handler;

import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.sample.websocket.jetty.server.HelloSocket2;

public class HelloHandler2 extends WebSocketHandler {

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.register(HelloSocket2.class);
        
    }

}
