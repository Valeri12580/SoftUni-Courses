package com.softuni.judgeversiontwo.utils;

import com.softuni.judgeversiontwo.utils.interfaces.ValidationUtil;
;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;


public class ValidationUtilImpl implements ValidationUtil {

    private javax.validation.Validator validator;

    public ValidationUtilImpl() {
        this.validator =  Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <T> boolean isValid(T entity) {
        return this.validator.validate(entity).isEmpty();
    }

    @Override
    public <T> Set<ConstraintViolation<T>> getViolations(T entity) {
        return this.validator.validate(entity);
    }
}
