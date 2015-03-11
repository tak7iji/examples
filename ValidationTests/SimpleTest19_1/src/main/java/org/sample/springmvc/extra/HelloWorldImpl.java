package org.sample.springmvc.extra;

import java.util.Set;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;


import javax.validation.Validator;

import org.springframework.web.context.ContextLoader;

@WebService
public class HelloWorldImpl {
    @Inject Validator validator;
    
    @WebMethod
    public String sayHi(@Valid @WebParam(name="message") MessageBean message) {
        Set<ConstraintViolation<MessageBean>> violations = validator.validate(message);
        for(ConstraintViolation<MessageBean> violation : violations) {
            System.out.println(violation.getMessage());
        }
        
        MessageBean mb = ContextLoader.getCurrentWebApplicationContext().getBean(MessageBean.class);
        mb.setMessage(message.getMessage());
        return mb.getMessage();
    }
    

}