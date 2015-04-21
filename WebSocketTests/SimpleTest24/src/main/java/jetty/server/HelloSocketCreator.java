package jetty.server;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.UpgradeHttpServletRequest;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

public class HelloSocketCreator implements WebSocketCreator {
    private HelloSocket helloSocket;


    public HelloSocketCreator() {
        this.helloSocket = new HelloSocket();
    }
    

    @Override
    public Object createWebSocket(ServletUpgradeRequest req,
            ServletUpgradeResponse resp) {
        UpgradeHttpServletRequest uhsr = (UpgradeHttpServletRequest) req.getHttpServletRequest();
        Request request = (Request) uhsr.getHttpServletRequest();
        request.setHandled(true);
        return this.helloSocket;
    }

}
