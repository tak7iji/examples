package jetty.server;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

public class HelloSocketCreator implements WebSocketCreator {
    private HelloSocket helloSocket;


    public HelloSocketCreator() {
        this.helloSocket = new HelloSocket();
    }
    

    @Override
    public Object createWebSocket(ServletUpgradeRequest req,
            ServletUpgradeResponse resp) {
        return this.helloSocket;
    }

}
