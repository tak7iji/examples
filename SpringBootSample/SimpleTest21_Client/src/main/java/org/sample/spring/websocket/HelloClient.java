package org.sample.spring.websocket;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.apache.log4j.Logger;

@ClientEndpoint
public class HelloClient {
    private Logger logger = Logger.getLogger(HelloClient.class);
    private CountDownLatch latch;
    private Session session;
    
    public HelloClient(CountDownLatch latch) {
        this.latch = latch;
    }
    
    @OnOpen
    public void onOpen(Session session) throws Exception {
        /* セッション確立時の処理 */
        session.getBasicRemote().sendText("Hello");
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) throws Exception {
        /* メッセージ受信時の処理 */
        logger.info("Received: " + message);
        session.getBasicRemote().sendText("Goodbye");
        latch.countDown();
    }

    @OnError
    public void onError(Throwable t) {
        /* エラー発生時の処理 */
    }

    @OnClose
    public void onClose(Session session) {
        /* セッション解放時の処理 */
    }
}