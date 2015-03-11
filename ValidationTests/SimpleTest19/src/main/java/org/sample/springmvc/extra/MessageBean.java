package org.sample.springmvc.extra;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component(value="mb")
public class MessageBean {
    @NotNull
    @Size(max=5, min=1)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Hello, "+message;
    }
}
