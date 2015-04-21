package org.sample.spring.websocket;

import java.io.IOException;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import javax.websocket.RemoteEndpoint.Basic;

import org.apache.log4j.Logger;

public class ServerEndpointSample extends Endpoint {
    private Logger logger = Logger.getLogger(ServerEndpointSample.class);

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        final Basic remote = session.getBasicRemote();
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            public void onMessage(String text) {
                try {
                    logger.info("Received message: "+text);
                    remote.sendText("Got your message (" + text + "). Thanks !");
                } catch (IOException ioe) {
                    // handle send failure here
                }
            }
        });
    }
}
