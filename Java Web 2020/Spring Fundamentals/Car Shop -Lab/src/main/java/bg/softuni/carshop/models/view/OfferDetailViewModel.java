package bg.softuni.carshop.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OfferDetailViewModel {
    private String imageUrl;
    private String modelBrandName;
    private String modelName;
    private int year;
    private String engine;
    private String transmission;
    private String sellerUsername;
    private double price;
    private LocalDateTime modified;
    private String description;
}
