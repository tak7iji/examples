package org.sample.struts1.exception;

import org.apache.struts.action.ActionForm;

public class TestFormBean extends ActionForm {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
