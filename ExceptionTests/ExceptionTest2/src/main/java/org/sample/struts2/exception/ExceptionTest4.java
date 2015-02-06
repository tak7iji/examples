package org.sample.struts2.exception;

import com.opensymphony.xwork2.ActionSupport;

public class ExceptionTest4 extends ActionSupport {

    // @Action + <global-exception-mappings>では、うまくハンドリングできない⇒package名をちゃんと指定すればOK
    public String execute() throws TestException {
        addActionError(getText("global.exception4"));
        throw new TestException();
    }
}
