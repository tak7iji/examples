package jetty.server;

import java.lang.management.ManagementFactory;
import java.util.concurrent.Executor;

import javax.management.MBeanServer;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.IdleTimeoutHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.websocket.server.WebSocketUpgradeHandlerWrapper;
import org.eclipse.jetty.websocket.server.pathmap.RegexPathSpec;

public class StartJetty { 
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        Executor executor = new QueuedThreadPool();
        ConnectionFactory connectionFactory = new HttpConnectionFactory();
        ConnectionFactory[] factories = {connectionFactory};
        
        // jmx setting
        MBeanServer mbServer = ManagementFactory.getPlatformMBeanServer();
        MBeanContainer mbContaienr = new MBeanContainer(mbServer);
        server.addBean(mbContaienr);
        
        // connector setting
        ServerConnector connector = new ServerConnector(server, executor, null, null, 0, 0, factories);
        connector.setPort(8080);
        server.setConnectors(new Connector[] { connector });

        // websocket context setting
        WebSocketUpgradeHandlerWrapper wsHandler = new WebSocketUpgradeHandlerWrapper();
        wsHandler.addMapping(new RegexPathSpec("/SimpleTest23/hellohandler"), new HelloSocketCreator());
        server.addBean(wsHandler);
        
        // 
        IdleTimeoutHandler itHandler = new IdleTimeoutHandler();
        itHandler.setIdleTimeoutMs(10000);
        
        // handler setting
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] {itHandler, wsHandler});
        server.setHandler(handlers);
        server.start();
        server.join();
    }
}
