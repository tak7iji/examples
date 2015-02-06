package org.sample.struts1.extra;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ExtraTest18 extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<RadioValue> radioValues = Arrays.asList(new RadioValue("ccc"), new RadioValue("ddd"));
        request.setAttribute("RadioValue", radioValues);

        Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put("eee", "CheckY");
        valueMap.put("fff", "CheckZ");
        request.setAttribute("MapValue", valueMap);

        return mapping.findForward("success");
	}
}