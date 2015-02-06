package org.sample.springmvc.extra;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldImpl {
    private ObjectBeanFactory factory = new ObjectBeanFactory();

    @WebMethod
    public String sayHi(String text) {
        MessageBean mb = factory.getBean();
        mb.setMessage(text);
        return mb.getMessage();
    }
    

}