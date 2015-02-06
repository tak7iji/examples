package org.sample.springmvc.extra;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserInfoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserInfo userinfo = (UserInfo)target;

        if("".equals(userinfo.getUsername())){
            errors.rejectValue("username", "required.username");
        }
        
        if("".equals(userinfo.getPassword())){
            errors.rejectValue("password", "required.password");
        }
        
    }

}
