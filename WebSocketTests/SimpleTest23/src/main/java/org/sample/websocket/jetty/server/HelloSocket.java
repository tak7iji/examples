package org.sample.websocket.jetty.server;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class HelloSocket {
    @OnWebSocketMessage
    public void onText(Session session, String message) {
        if (session.isOpen()) {
            System.out.printf("[Hello Socket] Echoing back message [%s]%n", message);
            session.getRemote().sendString(message, null);
        }
    }
}