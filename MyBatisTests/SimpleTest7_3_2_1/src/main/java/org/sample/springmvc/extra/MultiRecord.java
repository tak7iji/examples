package org.sample.springmvc.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultiRecord {
    @Autowired DBAccess dbAccess;
    
    @RequestMapping("/view")
    public ModelAndView execute() throws Exception {
        
        ModelAndView mav = new ModelAndView("list");
        try {
            mav.addObject("data", dbAccess.dbAccess());
        } catch (Throwable t) {
            System.out.println("Exception occured!");
            t.printStackTrace();
        }
        
        return mav;
    }

}
