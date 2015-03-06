package org.sample.springmvc.extra;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldImpl {

    private ObjectBeanFactory obf = new ObjectBeanFactory();
    
    @WebMethod
    public String sayHi(String text) {
        MessageBean mb = obf.getBean();
        System.out.println(this + ":" +mb);
        mb.setMessage(text);
        return mb.getMessage();
    }

}