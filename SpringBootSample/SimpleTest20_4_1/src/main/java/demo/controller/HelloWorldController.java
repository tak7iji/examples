package demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.beans.MessageBean;

@Controller
public class HelloWorldController {
    private Logger logger = Logger.getLogger(HelloWorldController.class);
    
    @Autowired MessageBean messageBean;
    
    @RequestMapping("/admin")
    public ModelAndView admin(@AuthenticationPrincipal User customUser) {
        logger.info("User: "+customUser.getAuthorities());
        ModelAndView mav = new ModelAndView("admin");
        mav.addObject("message", "Hello " + messageBean.getMessage() + "!");
        return mav;
    }
    
    @RequestMapping("/sec")
    public ModelAndView sayHiSecure(@AuthenticationPrincipal User customUser) {
        logger.info("User: "+customUser.getUsername());
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("message", "Hello " + messageBean.getMessage() + "!");
        return mav;
    }

    @RequestMapping("/")
    public ModelAndView sayHiNonSecure() {
        ModelAndView mav = new ModelAndView("hello_nonsecurity");
        mav.addObject("message", "Hello " + messageBean.getMessage() + "!!");
        return mav;
    }

}
