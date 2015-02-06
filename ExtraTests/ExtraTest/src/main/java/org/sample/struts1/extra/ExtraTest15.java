package org.sample.struts1.extra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class ExtraTest15 extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ActionMessages messages1 = new ActionMessages();
        ActionMessage message1 = new ActionMessage("メッセージ1", false);
        messages1.add("key1", message1);
        super.saveMessages(request, messages1);

        ActionMessages messages2 = new ActionMessages();
        ActionMessage message2 = new ActionMessage("メッセージ2", false);
        messages2.add("key2", message2);
        saveMessages(request, messages2);
        
        ActionMessages messages3 = new ActionMessages();
        ActionMessage message3 = new ActionMessage("メッセージ3", false);
        messages3.add("key3", message3);
        super.saveErrors(request, messages3);
        
        ActionMessages messages4 = new ActionMessages();
        ActionMessage message4 = new ActionMessage("メッセージ4", false);
        messages4.add("key4", message4);
        saveErrors(request, messages4);
        
        ActionMessages messages5 = new ActionMessages();
        ActionMessage message5 = new ActionMessage("global.test15");
        messages5.add("key5", message5);
        super.addMessages(request, messages5);
        
        ActionMessages messages6 = new ActionMessages();
        ActionMessage message6 = new ActionMessage("global.test15");
        messages6.add("key6", message6);
        super.addErrors(request, messages6);
        
        ActionMessages messages7 = new ActionMessages();
        String[] args = {"World", "!"};
        ActionMessage message7 = new ActionMessage("global.message.with.args", args);
        messages7.add("key7", message7);
        super.addMessages(request, messages7);
        
        return mapping.findForward("success");
	}
    
    @Override
    protected void saveMessages(HttpServletRequest request, ActionMessages messages) {
        // Remove any messages attribute if none are required
        if ((messages == null) || messages.isEmpty()) {
            request.removeAttribute("local.key");

            return;
        }

        // Save the messages we need
        request.setAttribute("local.key", messages);
    }
    
    @Override
    protected void saveErrors(HttpServletRequest request, ActionMessages errors) {
        // Remove any error messages attribute if none are required
        if ((errors == null) || errors.isEmpty()) {
            request.removeAttribute("local.error.key");

            return;
        }

        // Save the error messages we need
        request.setAttribute("local.error.key", errors);
    }

}