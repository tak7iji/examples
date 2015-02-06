package org.sample.struts1.extra;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class UserData4 extends ActionForm {

    private List<UserData> userData;
    private String stringData;

    public List<UserData> getUserData() {
        return userData;
    }

    public void setUserData(List<UserData> userData) {
        this.userData = userData;
    }

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

}
