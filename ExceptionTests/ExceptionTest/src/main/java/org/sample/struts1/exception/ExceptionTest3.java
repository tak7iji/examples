package org.sample.struts1.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.util.ModuleException;

public class ExceptionTest3 extends MappingDispatchAction {
    public ActionForward dispatch1(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, ModuleException {
        throw new ModuleException("global.exception4");
    }

    public ActionForward dispatch2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, ModuleException {
        throw new ModuleException("global.exception5");
    }

    public ActionForward dispatch3(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, ModuleException {
        throw new ModuleException("global.exception.no");
    }
}
