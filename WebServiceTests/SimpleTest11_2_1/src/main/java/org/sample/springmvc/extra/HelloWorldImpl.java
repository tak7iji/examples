package org.sample.springmvc.extra;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService
public class HelloWorldImpl {
    @Autowired MessageBean mb;

    @PostConstruct
    public void postConstruct(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @WebMethod
    public String sayHi(String text) {
        mb.setMessage(text);
        return mb.getMessage();
    }
    

}