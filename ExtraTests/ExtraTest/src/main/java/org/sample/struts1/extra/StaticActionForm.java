package org.sample.struts1.extra;

import org.apache.struts.action.ActionForm;

public class StaticActionForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String[] idData;
    private String[] nameData;

    public String[] getNameData() {
        return nameData;
    }

    public String[] getIdData() {
        return idData;
    }

    public void setIdData(String[] sIds) {
        this.idData = sIds;
    }

    public void setNameData(String[] sNames) {
        this.nameData = sNames;
    }

}
