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
@SpringApplicationConfiguration(classes = SimpleTest21Application.class)
@WebIntegrationTest
public class SimpleTest21ApplicationTests {
    @Test
    public void contextLoads() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI uri = URI.create("ws://127.0.0.1:8080/wsdemo");
        Session session = container.connectToServer(new HelloClient(latch), uri);
        
        latch.await();
        session.close();
    }
}
