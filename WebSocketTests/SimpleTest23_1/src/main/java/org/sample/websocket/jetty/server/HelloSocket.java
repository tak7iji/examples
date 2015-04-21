package org.sample.websocket.jetty.server;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.WebSocketAdapter;

public class HelloSocket extends WebSocketAdapter {

    @Override
    public void onWebSocketText(String message) {
        if (isConnected()) {
            try {
                System.out.printf("[HelloSocket2] Echoing back message [%s]%n", message);
                getRemote().sendString(message);
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
