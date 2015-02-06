package org.sample.struts1.extra;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.LabelValueBean;

public class ExtraTest17 extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        // P1 DynaActionForm
        DynaActionForm dynaList = (DynaActionForm) form;
        dynaList.set("userDataList", Arrays.asList(new LabelValueBean("地球", "00")));
        
        // P2 Listの要素がUserData
        List<UserData> list = Arrays.asList(new UserData("01", "北海道"),
                new UserData("<a href='http://www.google.com'>02</a>", "<a href='http://www.google.com'>東北</a>"), new UserData("03", "関東"));
        request.setAttribute("listData", list);
        
        // P3 valueとlabelを、それぞれ配列として保持
        String[] idArray = {"04", "05", "06"};
        String[] nameArray = {"甲信越", "中部", "東海"};
        request.setAttribute("idArray", idArray);
        request.setAttribute("nameArray", nameArray);
        
        // P4 Map
        Map<String, String> data = new HashMap<String, String>();
        data.put("07", "近畿");
        data.put("08", "中国");
        data.put("09", "四国");
        request.setAttribute("mapData", data);
        
        // P5 Iterator
        Iterator<UserData> iter = Arrays.asList(new UserData("10", "九州"),
                new UserData("11", "沖縄"), new UserData("12", "北陸")).iterator();
        request.setAttribute("iterator", iter);
        
        // P6 Enumeration
        Vector<UserData> vector = new Vector<UserData>();
        vector.add(new UserData("13", "米国"));
        vector.add(new UserData("14", "英国"));
        vector.add(new UserData("15", "中国"));
        request.setAttribute("enum", vector.elements());
        
        // P7 Beanのフィールドが配列、もしくは、コレクション
        UserData2 ud2 = new UserData2();
        String[] ids = {"16"};
        List<String> names = Arrays.asList("仏国");
        ud2.setIdArray(ids);
        ud2.setNameList(names);
        request.setAttribute("userData2", ud2);
        
        // P8 org.apache.struts.util.LabelValueBeanを利用
        List<LabelValueBean> lv = Arrays.asList(new LabelValueBean("伊国", "17"));
        request.setAttribute("labelValueBean", lv);
        
        // P9 UserDataの配列
        UserData[] udArray = {new UserData("18", "独国")};
        request.setAttribute("arrayUserData", udArray);
        
        // P10 BeanのフィールドがBeanのコレクション
        UserData3 ud3 = new UserData3();
        ud3.setUserDataList(Arrays.asList(new UserData("19", "西国")));
        request.setAttribute("userData3", ud3);
        
        return mapping.findForward("success");
	}
}