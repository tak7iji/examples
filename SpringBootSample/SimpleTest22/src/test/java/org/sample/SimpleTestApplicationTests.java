package org.sample;

import java.net.URI;
import java.util.concurrent.CountDownLatch;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimpleTestApplication.class)
@WebIntegrationTest("server.port:9000")
public class SimpleTestApplicationTests {
    @Test
    public void contextLoads() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI uri = URI.create("ws://127.0.0.1:9000/wsdemo");
        Session session = container.connectToServer(new HelloClient(latch), uri);
        
        latch.await();
        session.close();
    }
}
