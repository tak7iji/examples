package org.sample.struts1.mapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

public class MappingTest3 extends MappingDispatchAction {
    public ActionForward dispatch1(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("Request: " + ((TestFormBean)form).getMessage());
        return mapping.findForward("test3-dispatch2");

    }

    public ActionForward dispatch2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("Forward: " + ((TestFormBean)form).getMessage());
        return mapping.findForward("dispatch2");

    }

}
