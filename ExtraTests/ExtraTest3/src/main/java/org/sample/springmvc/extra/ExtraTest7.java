package org.sample.springmvc.extra;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtraTest7 {
    @RequestMapping(value="/test7")
    public String setup(Model model) {
        return "test7";
    }
}
