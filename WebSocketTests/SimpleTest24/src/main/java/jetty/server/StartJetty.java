package jetty.server;

import java.lang.management.ManagementFactory;
import java.util.concurrent.Executor;

import javax.management.MBeanServer;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.websocket.jsr356.server.pathmap.WebSocketPathSpec;
import org.eclipse.jetty.websocket.server.WebSocketUpgradeHandlerWrapper;

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
        wsHandler.addMapping(new WebSocketPathSpec("/SimpleTest23/hellohandler"), new HelloSocketCreator());
        server.addBean(wsHandler);
        
        // handler setting
        server.setHandler(wsHandler);
        server.start();
        server.join();
    }
}
