package org.sample.springmvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MappingTest1 {
    @RequestMapping(value="/test1")
    public String execute() {
        return "forward";
    }
}
