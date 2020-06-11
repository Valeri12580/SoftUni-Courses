package bg.softuni.carshop.models.binding;

import bg.softuni.carshop.models.enums.Category;
import bg.softuni.carshop.models.enums.Engine;
import bg.softuni.carshop.models.enums.Transmission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterOfferBindingModel {

    private String model;
    private int year;
    private long mileage;
    private double price;
    private String imageUrl;
    private Engine engine;
    private Category category;
    private Transmission transmission;
    private String sellerUsername;
    private String description;

}
