package org.sample.springmvc.auto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MessageBeanAuto3 {
    @Autowired Environment env;
    
    @Value("${message.text}")
    private String message;
    
    public String sayHelo() {
        return message;
    }

    @Value("${message.text2}") String msg2;
    public String sayHelo2() {
        return "Hello "+msg2;
    }
    
    public String sayHelo3() {
        // @PropertySourceで読み込まれたプロパティに対して有効
        return "Hello "+env.getProperty("message.text3", "Foo");
    }
    
    @Value("${message.text4}") String msg4;
    public String sayHelo4() {
        return "Hello "+msg4;
    }
    
    @Value("${message.text5}") String msg5;
    public String sayHelo5() {
        return "Hello "+msg5;
    }
    
    @Value("${message.text6}") String msg6;
    public String sayHelo6() {
        return "Hello "+msg6;
    }
    
    public String sayHelo7() {
        // @PropertySourceで読み込まれたプロパティに対して有効
        return "Hello "+env.getProperty("message.text7", "Foo");
    }
    
    @Value("${message.text8:Boo}") String msg8;
    public String sayHelo8() {
        return "Hello "+msg8;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

}
