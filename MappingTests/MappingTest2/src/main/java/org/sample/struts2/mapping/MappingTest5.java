package org.sample.struts2.mapping;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;

public class MappingTest5 extends ActionSupport {
    private TestFormBean message;

    public TestFormBean getMessage() {
        return message;
    }

    public void setMessage(TestFormBean message) {
        this.message = message;
    }

    @Action(value = "/test5-dispatch")
    public String dispatch() {
        String res = "";
        Map<String, Object> request = ActionContext.getContext()
                .getParameters();

        if (request.get("dispatch2") != null) {
            res = dispatch2();
        } else {
            res = dispatch1();
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
