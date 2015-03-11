package org.sample.springmvc.extra;

import java.util.Set;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;


import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.context.ContextLoader;

@WebService
public class HelloWorldImpl {
    @WebMethod
    public String sayHi(@WebParam(name="message") @NotNull @Size(max=5, min=1) String message) {
        MessageBean mb = ContextLoader.getCurrentWebApplicationContext().getBean(MessageBean.class);
        mb.setMessage(message);
        return mb.getMessage();
    }
    

}