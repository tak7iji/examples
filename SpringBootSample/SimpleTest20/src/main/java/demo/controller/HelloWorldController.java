package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.beans.MessageBean;

@Controller
public class HelloWorldController {
    
    @Autowired MessageBean messageBean;
    
    @RequestMapping("/")
    @ResponseBody
    public ModelAndView sayHi() {
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("message", "Hello " + messageBean.getMessage() + "!");
        return mav;
    }


}
