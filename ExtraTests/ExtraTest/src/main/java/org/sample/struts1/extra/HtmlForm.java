package org.sample.struts1.extra;

import org.apache.struts.action.ActionForm;

public class HtmlForm extends ActionForm {
    private String stringData;

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }
}
