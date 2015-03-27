package org.sample.spring.websocket;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimpleTest21Application implements CommandLineRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SimpleTest21Application.class, args);
        ctx.close();
    }

    @Override
    public void run(String... args) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI uri = URI.create("ws://127.0.0.1:8080/wsdemo");
        Session session = container.connectToServer(new HelloClient(), uri);
    }
}
