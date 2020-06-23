package bg.softuni.examprep.unitls.annotations;

import bg.softuni.examprep.services.interfaces.ItemService;
import bg.softuni.examprep.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueValidator implements ConstraintValidator<Unique,String> {
    private UserService userService;
    private ItemService itemService;
    private String type;

    @Autowired
    public UniqueValidator(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.type=constraintAnnotation.classType();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(type.equals("Item")){
            return  this.itemService.isItemNameFree(s);
        }
        return this.userService.isUsernameFree(s);
    }
}
