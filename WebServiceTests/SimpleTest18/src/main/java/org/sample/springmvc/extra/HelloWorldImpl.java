package org.sample.springmvc.extra;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldImpl extends AbstractHelloWorld {

    @WebMethod
    public String sayHi(String text) {
        MessageBean mb = applicationContext.getBean("mb", MessageBean.class);
        System.out.println(this + ":" +mb);
        mb.setMessage(text);
        return mb.getMessage();
    }

}