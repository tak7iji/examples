package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

    @RequestMapping("/auth/login")
    public String login() {
        return "/auth/login";
    }
}
