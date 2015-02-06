package org.sample.springmvc.extra;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
public class HelloWorldImpl {
    @Autowired MessageBean mb;

    @WebMethod
    public String sayHi(String text) {
        mb.setMessage(text);
        return mb.getMessage();
    }
    

}