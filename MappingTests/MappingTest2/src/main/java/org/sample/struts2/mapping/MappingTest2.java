package org.sample.struts2.mapping;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

public class MappingTest2 extends ActionSupport {
    private TestFormBean message;
    private String execute;

    public String getExecute() {
        return execute;
    }

    public void setExecute(String execute) {
        this.execute = execute;
    }

    public TestFormBean getMessage() {
        return message;
    }

    public void setMessage(TestFormBean message) {
        this.message = message;
    }

    @Action(value = "/test2-dispatch")
    public String dispatch() {
        String res = "";
        if ("dispatch1".equals(this.execute)) {
            res = dispatch1();
        } else if ("dispatch2".equals(this.execute)) {
            res = dispatch2();
        }

        return res;
    }

    public String dispatch1() {
        return "dispatch1";
    }

    public String dispatch2() {
        return "dispatch2";
    }
}
