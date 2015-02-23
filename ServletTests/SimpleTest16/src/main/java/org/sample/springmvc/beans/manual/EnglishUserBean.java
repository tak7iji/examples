package org.sample.springmvc.beans.manual;

import org.springframework.stereotype.Component;

@Component
public class EnglishUserBean implements UserBean {

    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
        return "Foo";
    }

}
