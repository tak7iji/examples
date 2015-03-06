package org.sample.springmvc.extra;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.web.context.ContextLoader;

@WebService
public class HelloWorldImpl  {

    @WebMethod
    public String sayHi(String text) {
        MessageBean mb = ContextLoader.getCurrentWebApplicationContext().getBean("mb", MessageBean.class);
        System.out.println(this + ":" +mb);
        mb.setMessage(text);
        return mb.getMessage();
    }

}