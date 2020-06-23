package bg.softuni.examprep.models.binding;

import bg.softuni.examprep.models.enums.CategoryType;
import bg.softuni.examprep.models.enums.Gender;
import bg.softuni.examprep.unitls.annotations.Unique;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class ItemRegisterBindingModel {

    @Unique(classType = "Item")
    @Size(min = 2,message = "Password length must be more than two characters")
    private String name;

    @Size(min = 3,message = "Password length must be more than three characters")
    private String description;


    private CategoryType category;

    private Gender gender;

    @PositiveOrZero(message = "Needs to be positive number!")
    private double price;
}
