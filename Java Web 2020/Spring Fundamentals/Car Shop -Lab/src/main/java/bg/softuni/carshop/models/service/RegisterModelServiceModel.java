package bg.softuni.carshop.models.service;

import bg.softuni.carshop.models.entity.Brand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterModelServiceModel {
    private String name;
    private int startYear;
    private int endYear;
    private String imageUrl;
    private String brand;
}
