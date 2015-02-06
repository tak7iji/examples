package org.sample.springmvc.exception;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTest1 {
    @Resource
    private MessageSource messageSource;
    
    @ExceptionHandler(TestException.class)
    public ModelAndView handler(Exception exception) {
        ModelAndView mav = new ModelAndView("error1");
        MessageSourceAccessor messageAccessor = new MessageSourceAccessor(
                messageSource);
        
        mav.addObject("message", messageAccessor.getMessage("global.exception1"));
        return mav;
    }
    
    @RequestMapping("/test1")
    public String execute() throws TestException {
        throw new TestException();
    }
}
