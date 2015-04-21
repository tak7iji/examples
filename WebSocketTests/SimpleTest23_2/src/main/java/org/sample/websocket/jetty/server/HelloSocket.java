package org.sample.websocket.jetty.server;

import java.io.IOException;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;

public class HelloSocket extends Endpoint{
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        final Basic remote = session.getBasicRemote();
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            public void onMessage(String text) {
                try {
                    remote.sendText("Got your message (" + text + "). Thanks !");
                } catch (IOException ioe) {
                    // handle send failure here
                }
            }
        });
    }
}