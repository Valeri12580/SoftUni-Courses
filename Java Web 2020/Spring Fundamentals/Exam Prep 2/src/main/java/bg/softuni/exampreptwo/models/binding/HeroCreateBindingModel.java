package bg.softuni.exampreptwo.models.binding;

import bg.softuni.exampreptwo.models.entity.HeroClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class HeroCreateBindingModel {
    private String name;

    private HeroClass heroClass;

    private int level;
    private String username;
}
