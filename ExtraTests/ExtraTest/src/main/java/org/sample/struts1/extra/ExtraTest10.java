package org.sample.struts1.extra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ExtraTest10 extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        TestBean tb1 = new TestBean();
        tb1.setUsername("request");
        tb1.getTestMap().put("foo", "bar");
        request.setAttribute("tbean", tb1);
        
        return mapping.findForward("success");
    }
}
