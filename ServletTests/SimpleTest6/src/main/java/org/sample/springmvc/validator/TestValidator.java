package org.sample.springmvc.validator;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Msg;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.springframework.validation.Errors;

public class TestValidator {
    public static boolean validateRequired(Object bean, ValidatorAction va, Errors errors, Field field) {
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());

        if(GenericValidator.isBlankOrNull(value) == true) {
            Msg msg = field.getMessage(va.getName());
            errors.rejectValue(field.getKey(), msg.getKey());
            return true;
        }
        return false;
    }
}
