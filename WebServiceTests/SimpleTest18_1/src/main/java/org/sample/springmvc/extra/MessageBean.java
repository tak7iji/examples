package org.sample.springmvc.extra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="mb")
@Scope("prototype")
public class MessageBean implements DisposableBean {
    private static final Logger logger = Logger.getLogger(MessageBean.class);

    @PostConstruct
    public void postConstruct() {
        logger.info("PostConstruct: "+this.getClass().getSimpleName());
    }

    @Override
    public void destroy() {
        System.out.println("PreDestroy: "+this.getClass().getSimpleName());
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Hello, "+message;
    }
}
