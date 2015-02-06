package org.sample.struts2.exception;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results(
        @Result(name="error1", location="error1.jsp")
)
@ExceptionMappings(
        @ExceptionMapping(exception="java.lang.Exception", result="error1")
)
public class ExceptionTest4_1 extends ActionSupport {

    @Action("/test4_1")
    public String execute() throws Exception {
        addActionError(getText("global.exception4"));
        throw new Exception("Yah!");
    }
}
