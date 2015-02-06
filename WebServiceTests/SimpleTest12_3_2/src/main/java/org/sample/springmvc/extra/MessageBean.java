package org.sample.springmvc.extra;

import org.springframework.stereotype.Component;

//@Component
public class MessageBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Hello, "+message;
    }
}
