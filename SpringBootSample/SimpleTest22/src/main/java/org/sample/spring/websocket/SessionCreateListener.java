package org.sample.spring.websocket;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class SessionCreateListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        request.getSession(true); // HttpSessionのインスタンスがなければ生成
    }
    public void requestDestroyed(ServletRequestEvent sre) {
        // nothing
    }
}