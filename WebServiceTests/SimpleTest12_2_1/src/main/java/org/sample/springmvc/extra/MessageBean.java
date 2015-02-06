package org.sample.springmvc.extra;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component(value="mb")
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class MessageBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Hello, "+message;
    }
}
