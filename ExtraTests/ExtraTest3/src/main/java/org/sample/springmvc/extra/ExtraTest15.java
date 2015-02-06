package org.sample.springmvc.extra;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtraTest15 {
    @RequestMapping(value="/test15")
    public ModelAndView  setup(WebRequest request) {
        request.setAttribute("key1", "メッセージ1", WebRequest.SCOPE_REQUEST);
        ModelAndView mav = new ModelAndView("test15");
        mav.addObject("key2", "メッセージ2");
        request.setAttribute("key3", "メッセージ3", WebRequest.SCOPE_SESSION);
        request.setAttribute("key4", "global.message", WebRequest.SCOPE_REQUEST);
        request.setAttribute("key5", "<a href='http://www.google.com'>google</a>", WebRequest.SCOPE_REQUEST);
        request.setAttribute("key6", "global.message.with.args", WebRequest.SCOPE_REQUEST);
        String[] args = {"World", "!"};
        request.setAttribute("args", Arrays.stream(args).collect(Collectors.joining(",")), WebRequest.SCOPE_REQUEST);
        return mav;
    }
}
