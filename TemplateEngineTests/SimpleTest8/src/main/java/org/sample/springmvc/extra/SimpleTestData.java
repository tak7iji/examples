package org.sample.springmvc.extra;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleTestData {
    @RequestMapping(value="/welcome", method=RequestMethod.POST)
    public ModelAndView execute(@Valid @ModelAttribute("mb") MessageBean mb, BindingResult bindingResult) {
//        System.out.println(this.mb);
//        System.out.println("execute: "+mb+", "+this);
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("login");
            mav.getModel().putAll(bindingResult.getModel());

            return mav;
        }
        ModelAndView mav = new ModelAndView("welcome");
        return mav;
    }
}