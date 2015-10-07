package org.sample.springmvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MappingTest2 {
	@ModelAttribute("message")
	public TestFormBean setupForm() {
		return new TestFormBean();
	}
	
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String execute(Model model) {
        return "dispatchaction";
    }

    @RequestMapping(value = "/test2-dispatch", params = "execute=dispatch1", method = RequestMethod.POST)
    public String dispatch1(TestFormBean message, Model model) {
    	model.addAttribute("message", message);
        return "dispatch1";
    }

    @RequestMapping(value = "/test2-dispatch", params = "execute=dispatch2", method = RequestMethod.POST)
    public String dispatch2(TestFormBean message, Model model) {
    	model.addAttribute("message", message);
        return "dispatch2";
    }

}
