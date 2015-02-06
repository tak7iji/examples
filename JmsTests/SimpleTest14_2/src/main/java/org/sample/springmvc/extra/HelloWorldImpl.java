package org.sample.springmvc.extra;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;

@WebService
public class HelloWorldImpl {
    private static Logger log = Logger.getLogger(HelloWorldImpl.class);
    private ObjectBeanFactory factory = new ObjectBeanFactory();

    @WebMethod
    public String sayHi(String text) {
        log.info("Start HelloWorldImpl");
        MessageBean mb = factory.getBean();
        mb.setMessage(text);
        return mb.getMessage();
    }
    

}