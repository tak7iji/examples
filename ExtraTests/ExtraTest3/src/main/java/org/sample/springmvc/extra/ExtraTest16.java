package org.sample.springmvc.extra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtraTest16 {
    @RequestMapping("/result")
    public String result(@ModelAttribute("selectedValue") SelectedValue selectedValue) {
        return "result";
    }
    
    @RequestMapping("/test16")
    public ModelAndView execute() {
        
        ModelAndView mav = new ModelAndView("test16");
        SelectedValue selectedValue = new SelectedValue();
        mav.addObject("selectedValue", selectedValue);
        
        // P2 Listの要素がUserData
        List<UserData> list = Arrays.asList(new UserData("01", "北海道"),
                new UserData("<a href='http://www.google.com'>02</a>", "<a href='http://www.google.com'>東北</a>"), new UserData("03", "関東"));
        mav.addObject("listData", list);
        
        // P3 valueとlabelを、それぞれ配列として保持
        String[] idArray = {"04", "05", "06"};
        String[] nameArray = {"甲信越", "中部", "東海"};
        mav.addObject("idArray", idArray);
        mav.addObject("nameArray", nameArray);
        
        // P4 Map
        Map<String, String> data = new HashMap<String, String>();
        data.put("07", "近畿");
        data.put("08", "中国");
        data.put("09", "四国");
        mav.addObject("mapData", data);
        
        // P5 Iterator
        Iterator<UserData> iter = Arrays.asList(new UserData("10", "九州"),
                new UserData("11", "沖縄"), new UserData("12", "北陸")).iterator();
        mav.addObject("iterator", iter);

        // P6 Enumeration
        Vector<UserData> vector = new Vector<UserData>();
        vector.add(new UserData("13", "米国"));
        vector.add(new UserData("14", "英国"));
        vector.add(new UserData("15", "中国"));
        mav.addObject("vector", vector.elements());
        
        // P7 Beanのフィールドが配列、もしくは、コレクション
        UserData2 ud2 = new UserData2();
        String[] ids = {"16"};
        List<String> names = Arrays.asList("仏国");
        ud2.setIdArray(ids);
        ud2.setNameList(names);
        mav.addObject("userData2", ud2);
        
        // P9 UserDataの配列
        UserData[] udArray = {new UserData("18", "独国")};
        mav.addObject("arrayUserData", udArray);

        // P10 BeanのフィールドがBeanのコレクション
        UserData3 ud3 = new UserData3();
        ud3.setUserDataList(Arrays.asList(new UserData("19", "西国")));
        mav.addObject("userData3", ud3);

        return mav;
	}
}