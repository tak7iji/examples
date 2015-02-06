package org.sample.struts1.mapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.apache.struts.actions.MappingDispatchAction;

public class MappingTest10 extends MappingDispatchAction {
    public ActionForward dispatch1(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("Request: " + ((TestFormBean)form).getMessage());
        return mapping.findForward("test10forward");

    }

    public ActionForward dispatch2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("Request: " + ((TestFormBean)form).getMessage());
        ActionRedirect redirect = new ActionRedirect(mapping.findForward("test10redirect"));
        redirect.addParameter("message", ((TestFormBean)form).getMessage());

        return redirect;

    }

}
