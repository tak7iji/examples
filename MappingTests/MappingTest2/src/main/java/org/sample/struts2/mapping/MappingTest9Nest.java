package org.sample.struts2.mapping;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/test9")
public class MappingTest9Nest extends ActionSupport {
    private TestFormBean message;

    public TestFormBean getMessage() {
        return message;
    }

    public void setMessage(TestFormBean message) {
        this.message = message;
    }

    @Action("/test9_dispatch1")
    public String dispatch1() {
        return "dispatch1";
    }

    @Action("/test9_dispatch2")
    public String dispatch2() {
        return "dispatch2";
    }
}
