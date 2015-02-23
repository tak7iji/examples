package org.sample.springmvc.beans.manual;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MessageBean4 {
    private String message;
    
    public MessageBean4() {
        this.message = "Hello Bean4";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
