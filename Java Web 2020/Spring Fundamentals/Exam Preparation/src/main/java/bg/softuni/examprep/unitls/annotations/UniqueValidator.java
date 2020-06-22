package bg.softuni.examprep.unitls.annotations;

import bg.softuni.examprep.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueValidator implements ConstraintValidator<Unique,String> {
    private UserService userService;

    @Autowired
    public UniqueValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(Unique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return this.userService.isUsernameFree(s);
    }
}
