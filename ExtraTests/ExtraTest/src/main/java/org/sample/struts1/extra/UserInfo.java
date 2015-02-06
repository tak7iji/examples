package org.sample.struts1.extra;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorActionForm;
import org.apache.struts.validator.ValidatorForm;

public class UserInfo extends ActionForm {
//public class UserInfo extends ValidatorActionForm {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping,
            javax.servlet.http.HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if("".equals(getUsername())) {
            errors.add("username", new ActionMessage("username.required"));
        }
        if("".equals(getPassword())) {
            errors.add("password", new ActionMessage("password.required"));           
        }
        System.out.println(errors);
        return errors;
    }
}
