package org.sample.springmvc.exception;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTest2 {
    @Resource
    private MessageSource messageSource;
    
    @ExceptionHandler(IOException.class)
    public ModelAndView handler(Exception exception) {
        ModelAndView mav = new ModelAndView("error1");
        MessageSourceAccessor messageAccessor = new MessageSourceAccessor(
                messageSource);
        
        mav.addObject("message", messageAccessor.getMessage("global.exception3"));
        return mav;
    }
    
    @RequestMapping("/test2")
    public String execute() throws TestException {
        return "error-jsp";
    }
}
