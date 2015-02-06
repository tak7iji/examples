package org.sample.struts2.extra;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ExtraTest5 extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private TestBean tbean;

    @Override
    public String execute() {
        TestBean tb1 = new TestBean();
        tb1.setUsername("request");
        setTbean(tb1);
        
        TestBean tb2 = new TestBean();
        tb2.setUsername("session");
        session.put("tbean_session", tb2);
        
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;        
    }

    public TestBean getTbean() {
        return tbean;
    }

    public void setTbean(TestBean tbean) {
        this.tbean = tbean;
    }
}
