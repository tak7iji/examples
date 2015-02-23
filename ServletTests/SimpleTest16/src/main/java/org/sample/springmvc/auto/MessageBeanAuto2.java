package org.sample.springmvc.auto;

import org.springframework.stereotype.Component;

@Component
public class MessageBeanAuto2 {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
