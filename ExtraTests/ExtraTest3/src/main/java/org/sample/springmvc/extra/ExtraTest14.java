package org.sample.springmvc.extra;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtraTest14 {
    @RequestMapping("/result14")
    public String result(@ModelAttribute("multiBoxTest") MultiBoxTest multiBoxTest) {
        System.out.println("Data length: " + ((multiBoxTest.getData() != null) ? multiBoxTest.getData().length : "null"));
        System.out.println("checkedArray length: " + ((multiBoxTest.getCheckedArray() != null) ? multiBoxTest.getCheckedArray().length : "null"));
        return "result14";
    }
    
    @RequestMapping("/test14")
    public ModelAndView execute14() {
        ModelAndView mav = new ModelAndView("test14");
        mav.addObject("multiBoxTest", new MultiBoxTest());
        return mav;
	}

    @RequestMapping("/test14-2")
    public ModelAndView execute14_2() {
        ModelAndView mav = new ModelAndView("test14-2");
        mav.addObject("multiBoxTest", new MultiBoxTest());
        return mav;
    }

    @RequestMapping("/test14-3")
    public ModelAndView execute14_3() {
        ModelAndView mav = new ModelAndView("test14-3");
        mav.addObject("multiBoxTest", new MultiBoxTest());
        return mav;
    }

    @RequestMapping("/test14-5")
    public ModelAndView execute14_5() {
        ModelAndView mav = new ModelAndView("test14-5");
        mav.addObject("multiBoxTest", new MultiBoxTest());
        return mav;
    }
}