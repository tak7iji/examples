package org.sample.struts1.mapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

public class MappingTest4 extends LookupDispatchAction {

    @Override
    protected Map getKeyMethodMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("submit.dispatch1", "dispatch1");
        map.put("submit.dispatch2", "dispatch2");
        return map;
    }

    public ActionForward dispatch1(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        return mapping.findForward("dispatch1");

    }

    public ActionForward dispatch2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        return mapping.findForward("dispatch2");

    }
}
