package org.sample.springmvc.beans.manual;

import org.springframework.stereotype.Component;

public class MessageBean8 {
    private String message;
    
    public MessageBean8() {
        this.message = "Hello Bean5";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
