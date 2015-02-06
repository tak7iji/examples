package org.sample.struts1.extra;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class ExtraTest19 extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        saveToken(request);
        DynaActionForm dform = (DynaActionForm) form;
        dform.set("stringData", null);
        
        // Query P1
        request.setAttribute("singleValue1", "single1");
        
        // Query P2
        SingleParameter sp = new SingleParameter("single2");
        request.setAttribute("singleValue2", sp);
        
        // Query P3
        Map<String, String> map = new HashMap<String, String>();
        map.put("map1", "data1");
        map.put("map2", "data2");
        map.put("map3", "data3");
        request.setAttribute("mapValue1", map);
        
        // Query P4
        MappedParameter mp = new MappedParameter(map);
        request.setAttribute("mapValue2", mp);
        
        // Test
        request.setAttribute("testValue", null);
        
        return mapping.findForward("success");
	}
}