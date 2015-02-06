package org.sample.struts2.extra;

import com.opensymphony.xwork2.ActionSupport;

public class ExtraTest7_1 extends ActionSupport {
    private TestBean tbean;

    @Override
    public String execute() {
        TestBean tb1 = new TestBean();
        tb1.setUsername("global.username");
        setTbean(tb1);
        return SUCCESS;
    }

    public TestBean getTbean() {
        return tbean;
    }

    public void setTbean(TestBean tbean) {
        this.tbean = tbean;
    }
}
