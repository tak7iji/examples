package org.sample.springmvc.extra;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService
public class HelloWorldImpl {
    private static Logger log = Logger.getLogger(HelloWorldImpl.class);
    @Autowired MessageBean messageBean;

    @PostConstruct
    public void postConstruct(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @WebMethod
    public String sayHi(String text) {
        log.info("Start HelloWorldImpl");
        messageBean.setMessage(text);
        return messageBean.getMessage();
    }
    

}