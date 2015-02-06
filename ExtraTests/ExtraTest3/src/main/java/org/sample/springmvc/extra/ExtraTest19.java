package org.sample.springmvc.extra;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test19")
public class ExtraTest19 {
    @RequestMapping
    public String execute() {
        return "test19";
    }
    
    @RequestMapping("/test1/{name}/{id}")
    public ModelAndView test19(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("test19");
        mav.addObject("id", id);
        return mav;
	}
    
    @RequestMapping("/test2/{id}")
    public ModelAndView test19_1(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("test19");
        mav.addObject("id", id);
        return mav;
    }
    
    @RequestMapping("/test3/{name}")
    public ModelAndView test19_2() {
        return new ModelAndView("test19");
    }
}