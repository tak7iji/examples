package org.sample.struts2.mapping;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

public class MappingTest3 extends ActionSupport {
    private TestFormBean message;

    public TestFormBean getMessage() {
        return message;
    }

    public void setMessage(TestFormBean message) {
        this.message = message;
    }

    /*
     * struts.xmlに記述する場合は、以下のようにする 
     * <action name="test3-dispatch1" class="org.sample.struts2.mapping.MappingTest3" method="dispatch1">
     *   <result name="test3-dispatch2" type="redirectAction">
     *     <param name="actionName">test3-dispatch2</param> <param name="namespace"/>
     *     <param name="message.message">${message.message}</param>
     *   </result>
     * </action>
     */
//    @Action(value = "/test3_dispatch1", results = { @Result(name = "test3-dispatch2", location = "test3-dispatch2", type = "redirectAction", params = {
//            "message.message", "${message.message}" }) })
    @Action(value = "/test3_dispatch1")
    public String dispatch1() {
        return "test3_dispatch2";
    }

    @Action(value = "/test3_dispatch1-test3_dispatch2")
    public String dispatch2() {
        System.out.println("Message: " + getMessage().getMessage());
        return "dispatch2";
    }
}
