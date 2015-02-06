package org.sample.springmvc.exception;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTest3 {
    @Resource
    private MessageSource messageSource;

    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public String execute(Model model) {
        model.addAttribute("message", new TestFormBean());
        return "mappingdispatchaction3";
    }

    @RequestMapping(value = "/test3-dispatch1", method = RequestMethod.POST)
    public ModelAndView dispatch1(@ModelAttribute("message") TestFormBean message) {
        try {
            throw new Exception();
        } catch(Exception ex) {
            ModelAndView mav = new ModelAndView("error1");
            MessageSourceAccessor messageAccessor = new MessageSourceAccessor(
                    messageSource);
            
            mav.addObject("message", messageAccessor.getMessage("global.exception4"));
            return mav;
        }
    }

    @RequestMapping(value = "/test3-dispatch2")
    public ModelAndView dispatch2(@ModelAttribute("message") TestFormBean message) {
        try {
            throw new Exception();
        } catch(Exception ex) {
            ModelAndView mav = new ModelAndView("error2");
            MessageSourceAccessor messageAccessor = new MessageSourceAccessor(
                    messageSource);
            
            mav.addObject("message", messageAccessor.getMessage("global.exception5"));
            return mav;
        }
    }

    @RequestMapping(value = "/test3-dispatch3")
    public ModelAndView dispatch3(@ModelAttribute("message") TestFormBean message) throws TestException {
        throw new TestException();
    }

}
