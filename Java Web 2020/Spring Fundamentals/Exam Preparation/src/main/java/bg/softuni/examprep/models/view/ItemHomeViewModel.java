package bg.softuni.examprep.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ItemHomeViewModel {
    private String id;
    private String name;
    private double price;
    private String imageUrl;
}
