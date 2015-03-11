package org.sample.springmvc.extra;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;

@WebService
public class HelloWorldImpl {
    @Autowired Validator validator;
    @Autowired MessageBean mb;

    @WebMethod
    public String sayHi(@Valid @WebParam(name="message") MessageBean message) {
        BeanPropertyBindingResult br = new BeanPropertyBindingResult(message, "message");
        validator.validate(message, br);
        if (br.hasErrors()) {
            for(ObjectError error : br.getAllErrors()) {
                System.out.println("Error: "+error.getDefaultMessage());
            }
        }

        System.out.println(validator);
//        MessageBean mb = ContextLoader.getCurrentWebApplicationContext().getBean("mb", MessageBean.class);
        mb.setMessage(message.getMessage());
        return mb.getMessage();
    }
    

}