package bg.softuni.carshop.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferPreviewViewModel {
    private long id;
    private String brandName;
    private String modelName;
    private String engine;

}
