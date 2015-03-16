package org.sample.springmvc.extra;

import java.util.Collections;

import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultiRecord {
    @Autowired DBAccess dbAccess;
    
    @RequestMapping("/list")
    public ModelAndView execute() throws Exception {
        
        ModelAndView mav = new ModelAndView("list");
        try {
            mav.addObject("data", dbAccess.dbAccess());
//            TestTable tt = new TestTable();
//            tt.setId(1);
//            tt.setName("foo");
//            tt.setAddress("bar");
//            mav.addObject("data", Collections.singletonList(tt));
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        return mav;
    }

}
