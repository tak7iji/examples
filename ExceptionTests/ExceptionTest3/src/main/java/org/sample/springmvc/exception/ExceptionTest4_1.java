package org.sample.springmvc.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionTest4_1 {
    @RequestMapping("/test4_1")
    public String execute() throws Exception {
        throw new Exception();
    }
}
