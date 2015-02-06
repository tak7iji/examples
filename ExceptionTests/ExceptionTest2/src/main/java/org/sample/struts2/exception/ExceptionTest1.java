package org.sample.struts2.exception;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ExceptionMapping;

public class ExceptionTest1 extends ActionSupport {
    @Action(value="/test1", 
            results={@Result(name="error1", location="error1.jsp")}, 
            exceptionMappings={@ExceptionMapping(exception="java.io.IOException", result="error1")}
            )
    public String execute() throws IOException {
        addActionError(getText("global.exception1"));
        throw new IOException("Wow");
    }
}
