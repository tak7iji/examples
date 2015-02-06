package org.sample.springmvc.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class SimpleTest {
    @RequestMapping("/logon")
    public String login(Model model) {
//        System.out.println("login: "+mb+", "+this);
        MessageBean mb = new MessageBean();
        mb.setMessage("Hello World");
        model.addAttribute("mb", mb);
        return "login";
    }
    
}