package org.sample.springmvc.extra;

import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.ValidatorResources;
import org.apache.commons.validator.ValidatorResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserInfoValidator implements Validator {
    @Autowired
    ValidatorResources validatorResource;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserInfo userinfo = (UserInfo) target;

        org.apache.commons.validator.Validator validator = new org.apache.commons.validator.Validator(
                validatorResource, "validateUser");
        // TestValidatorに渡す引数を設定
        validator.setParameter("org.springframework.validation.Errors", errors);
        validator.setParameter(
                org.apache.commons.validator.Validator.BEAN_PARAM, userinfo);
        try {
            ValidatorResults validatorResults = validator.validate();
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

}
