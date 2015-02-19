package org.sample.springmvc.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultiRecord {
    @Autowired DBAccess dbAccess;
    
    @RequestMapping("/list/{type}")
    public ModelAndView execute(@PathVariable int type) throws Exception {
        
        ModelAndView mav = new ModelAndView("list1");
        try {
            mav.addObject("data", dbAccess.dbAccess(type));
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        return mav;
    }

    @RequestMapping("/list2")
    public ModelAndView execute2() throws Exception {
        
        ModelAndView mav = new ModelAndView("list2");
        try {
            mav.addObject("data", dbAccess.dbAccess2());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        return mav;
    }

}
