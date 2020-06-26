package bg.softuni.exampreptwo.models.view;

import bg.softuni.exampreptwo.models.entity.HeroClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroHomeViewModel {
    private String id;
    private String imageUrl;
    private HeroClass heroClass;
    private String userUsername;
}
