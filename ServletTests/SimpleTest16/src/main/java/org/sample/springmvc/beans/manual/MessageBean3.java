package org.sample.springmvc.beans.manual;

import org.springframework.stereotype.Component;

@Component
public class MessageBean3 {
    private String message;
    
    public MessageBean3() {
        this.message = "Hello Bean3";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
