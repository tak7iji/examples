package org.sample.springmvc.extra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtraTest18 {
    @RequestMapping("/result18")
    public String result(@ModelAttribute("selectedValue") SelectedValue selectedValue) {
        return "result";
    }
    
    @RequestMapping("/test18")
    public ModelAndView execute() {
        
        ModelAndView mav = new ModelAndView("test18");
        SelectedValue selectedValue = new SelectedValue();
        mav.addObject("selectedValue", selectedValue);
        
        List<RadioValue> radioValues = Arrays.asList(new RadioValue("ccc"), new RadioValue("ddd"));
        mav.addObject("RadioValue", radioValues);
        
        Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put("eee", "CheckY");
        valueMap.put("fff", "CheckZ");
        mav.addObject("MapValue", valueMap);

        return mav;
	}
}