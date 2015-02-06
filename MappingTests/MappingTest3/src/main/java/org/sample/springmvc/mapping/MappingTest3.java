package org.sample.springmvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MappingTest3 {
    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public String execute(Model model) {
        model.addAttribute("message", new TestFormBean());
        return "mappingdispatchaction";
    }

    // to forward to another controller: return "forward:test3-dispatch2"
    @RequestMapping(value = "/test3-dispatch1", method = RequestMethod.POST)
    public String dispatch1(@ModelAttribute("message") TestFormBean message, final RedirectAttributes redirectAttributes) {
        System.out.println("Request: " + message.getMessage());
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:test3-dispatch2";
    }

    @RequestMapping(value = "/test3-dispatch2")
    public String dispatch2(@ModelAttribute("message") TestFormBean message) {
        System.out.println("Redirect: " + message.getMessage());
        return "dispatch2";
    }

}
