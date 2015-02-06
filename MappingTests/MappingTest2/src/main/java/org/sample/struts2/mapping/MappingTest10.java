package org.sample.struts2.mapping;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

public class MappingTest10 extends ActionSupport {
    private TestFormBean message;

    public TestFormBean getMessage() {
        return message;
    }

    public void setMessage(TestFormBean message) {
        this.message = message;
    }

    @Action(value = "/forward1")
    public String dispatch1() {
        return "test10forward1";
    }
}
