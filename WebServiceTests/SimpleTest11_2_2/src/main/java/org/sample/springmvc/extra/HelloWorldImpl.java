package org.sample.springmvc.extra;

import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@WebService
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class HelloWorldImpl {
    @Autowired MessageBean mb;

    @WebMethod
    public String sayHi(String text) {
        mb.setMessage(text);
        return mb.getMessage();
    }
}