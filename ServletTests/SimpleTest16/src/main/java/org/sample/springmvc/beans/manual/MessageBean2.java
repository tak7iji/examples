package org.sample.springmvc.beans.manual;

import org.springframework.stereotype.Component;

@Component
public class MessageBean2 {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
