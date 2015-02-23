package org.sample.springmvc.beans.manual;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// EnglishUserBeanよりも優先される
@Component
//@Primary
public class JapaneseUserBean implements UserBean {

    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
        return "某";
    }

}
