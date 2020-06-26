package bg.softuni.exampreptwo.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroDetailViewModel {
    private String name;
    private String heroClass;
    private int level;
}
