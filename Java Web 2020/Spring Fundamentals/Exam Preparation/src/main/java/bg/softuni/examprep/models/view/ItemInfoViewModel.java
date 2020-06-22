package bg.softuni.examprep.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemInfoViewModel {
    private String id;
    private String name;
    private String description;
    private double price;
}
