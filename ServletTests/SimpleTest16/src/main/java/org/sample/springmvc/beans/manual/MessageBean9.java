package org.sample.springmvc.beans.manual;

import org.springframework.stereotype.Component;

public class MessageBean9 {
    private String message;
    
    public MessageBean9() {
        this.message = "Hello Bean5";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
