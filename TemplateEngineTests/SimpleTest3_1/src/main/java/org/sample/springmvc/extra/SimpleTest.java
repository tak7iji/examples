package org.sample.springmvc.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleTest {
    @Autowired MessageBean mb;
    
    @RequestMapping("/welcome")
    public ModelAndView execute() {
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("messageBean", mb);
        return mav;
    }
}