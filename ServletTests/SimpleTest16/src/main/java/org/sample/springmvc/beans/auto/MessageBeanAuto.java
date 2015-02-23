package org.sample.springmvc.beans.auto;

import org.springframework.stereotype.Component;

@Component
public class MessageBeanAuto {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
