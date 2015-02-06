package org.sample.springmvc.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultiRecord2 {
    @Autowired DBAccess2 dbAccess2;
    
    @RequestMapping("/list2")
    public ModelAndView execute() throws Exception {
        
        ModelAndView mav = new ModelAndView("list");
        try {
            mav.addObject("data", dbAccess2.dbAccess());
        } finally {
        }
        
        return mav;
    }

}
