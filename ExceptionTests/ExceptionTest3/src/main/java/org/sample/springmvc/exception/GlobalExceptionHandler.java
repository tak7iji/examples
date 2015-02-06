package org.sample.springmvc.exception;

import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Resource
    private MessageSource messageSource;
    
    @ExceptionHandler(TestException.class)
    public ModelAndView handler(Exception ex, WebRequest request) {
        ModelAndView mav = new ModelAndView("error1");
        MessageSourceAccessor messageAccessor = new MessageSourceAccessor(
                messageSource);
        
        mav.addObject("message", messageAccessor.getMessage("global.exception8"));

        Iterator<String> iter = request.getParameterNames();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        return mav;
        
    }

}
