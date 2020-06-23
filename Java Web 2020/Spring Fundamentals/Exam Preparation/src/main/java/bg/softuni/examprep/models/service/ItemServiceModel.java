package bg.softuni.examprep.models.service;

import bg.softuni.examprep.models.entities.Category;
import bg.softuni.examprep.models.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemServiceModel {
    private String id;
    private String name;

    private String description;
    private double price;

    private Category category;
    private Gender gender;
    private String imageUrl;
}
