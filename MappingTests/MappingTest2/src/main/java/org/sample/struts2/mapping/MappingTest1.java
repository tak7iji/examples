package org.sample.struts2.mapping;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({ @Result(name = "success", location = "forward.jsp") })
public class MappingTest1 extends ActionSupport {
    @Action("/test1")
    public String execute() {
        return SUCCESS;
    }

}
