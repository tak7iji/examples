package org.sample.springmvc.exception;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTest5 {
    @Resource
    private MessageSource messageSource;
    
    private TestFormBean message;
    
    @ExceptionHandler(TestException.class)
    public ModelAndView handler(Exception exception) {
        System.out.println(message);
        ModelAndView mav = new ModelAndView("error1");
        MessageSourceAccessor messageAccessor = new MessageSourceAccessor(
                messageSource);
        
        mav.addObject("message", messageAccessor.getMessage("global.exception7"));
        return mav;
    }

    @RequestMapping(value = "/test5", method = RequestMethod.GET)
    public String execute(Model model) {
        model.addAttribute("message", new TestFormBean());
        return "action";
    }

    @RequestMapping(value = "/test5-dispatch", method = RequestMethod.POST)
    public ModelAndView dispatch1(@ModelAttribute("message") TestFormBean message) throws TestException {
        this.message = message;
        throw new TestException();
    }

}
