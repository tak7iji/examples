package org.sample.struts2.extra;

import com.opensymphony.xwork2.ActionSupport;

public class ExtraTest2 extends ActionSupport {

    private UserInfo userinfo;
    private String submit;

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    public String execute() {
        return "SUCCESS";
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    // validation ruleを使用しない場合に使うメソッド
//    public void validate() {
//        if ("".equals(userinfo.getUsername())) {
//            addFieldError("userinfo.username", getText("username.required"));
//        }
//        if ("".equals(userinfo.getPassword())) {
//            addFieldError("userinfo.password", getText("password.required"));
//        }
//    }

}