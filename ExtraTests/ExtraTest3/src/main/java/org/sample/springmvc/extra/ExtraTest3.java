package org.sample.springmvc.extra;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtraTest3 {
    @RequestMapping(value="/test3", method = RequestMethod.GET)
    public String setup(Model model) {
        if(!model.containsAttribute("value")) {
            model.addAttribute("value", new MapBackedForm());
        }
        return "test3";
    }
    
    @RequestMapping(value="/test3-input", method=RequestMethod.POST)
    public ModelAndView execute(@ModelAttribute(value="value") MapBackedForm mbForm) {

        ModelAndView mav = new ModelAndView("test3-result");
        mav.addObject("result", mbForm.getValue());
        mav.addObject("message_key", "global.message");
        
        return mav;
    }
}
