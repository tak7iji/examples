package org.sample;

import java.util.concurrent.CountDownLatch;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class HelloClient {
    private CountDownLatch latch;

    public HelloClient(CountDownLatch latch) {
        this.latch = latch;
    }
    
    @OnOpen
    public void onOpen(Session session) throws Exception {
        /* セッション確立時の処理 */
        session.getBasicRemote().sendText("Hello");
    }

    @OnMessage
    public void onMessage(String message) throws Exception {
        /* メッセージ受信時の処理 */
        System.out.println("Received: " + message);
        this.latch.countDown();
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