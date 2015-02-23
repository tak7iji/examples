package org.sample.springmvc.beans.manual;

import org.springframework.stereotype.Component;

@Component
public class MessageBean7 {
    private String message;
    
    public MessageBean7() {
        this.message = "Hello Bean5";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
