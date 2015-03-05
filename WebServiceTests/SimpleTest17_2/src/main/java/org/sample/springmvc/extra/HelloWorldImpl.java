package org.sample.springmvc.extra;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService
public class HelloWorldImpl {
    private static Logger logger = Logger.getLogger(HelloWorldImpl.class);
    @Autowired MessageBean mb;

    @PostConstruct
    public void postConstruct(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @WebMethod
    public String sayHi(String text) {
//        MessageBean mb = ContextLoader.getCurrentWebApplicationContext().getBean("mb", MessageBean.class);
        
        logger.info(this + ":" + mb);
        mb.setMessage(text);
        return mb.getMessage();
    }
    

}