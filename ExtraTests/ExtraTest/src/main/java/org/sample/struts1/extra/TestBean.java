package org.sample.struts1.extra;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorActionForm;
import org.apache.struts.validator.ValidatorForm;

//public class UserInfo extends ActionForm {
public class TestBean extends ValidatorActionForm {
    private String username;
    private String password;
    private Map<Object, Object> testMap = new HashMap<Object, Object>(10);
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
    public Map<Object, Object> getTestMap() {
        return testMap;
    }
    public void setTestMap(Map<Object, Object> testMap) {
        this.testMap = testMap;
    }
}
