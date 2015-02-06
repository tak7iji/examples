package org.sample.springmvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test9")
public class MappingTest9Nest {
    @RequestMapping(method = RequestMethod.GET)
    public String execute(Model model) {
        model.addAttribute("message", new TestFormBean());
        return "mappingdispatchaction2";
    }

    @RequestMapping(value = "/Nest/dispatch1", method = RequestMethod.POST)
    public String dispatch1(@ModelAttribute("message") TestFormBean message) {
        return "dispatch1";
    }

    @RequestMapping(value = "/Nest/dispatch2", method = RequestMethod.POST)
    public String dispatch2(@ModelAttribute("message") TestFormBean message) {
        return "dispatch2";
    }
}
