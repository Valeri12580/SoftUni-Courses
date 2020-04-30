package utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


public class ValidationUtilImpl  {

    private Validator validator;

    public ValidationUtilImpl() {
        this.validator =  Validation.buildDefaultValidatorFactory().getValidator();
    }


    public <T> boolean isValid(T entity) {
        return this.validator.validate(entity).isEmpty();
    }


    public <T> Set<ConstraintViolation<T>> getViolations(T entity) {
        return this.validator.validate(entity);
    }
}
