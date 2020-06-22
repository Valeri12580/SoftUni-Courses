package bg.softuni.examprep.unitls.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    String message() default "User with that username already exists!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
