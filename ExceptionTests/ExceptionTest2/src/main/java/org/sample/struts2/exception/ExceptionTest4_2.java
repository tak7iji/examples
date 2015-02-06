package org.sample.struts2.exception;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

@ParentPackage("exception-test")
public class ExceptionTest4_2 extends ActionSupport {

    @Action(value="/test4_2")
    public String execute() throws TestException {
        addActionError(getText("global.exception4"));
        throw new TestException("Oops!");
    }
}
