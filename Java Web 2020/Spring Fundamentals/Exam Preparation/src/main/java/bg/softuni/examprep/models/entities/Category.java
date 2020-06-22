package bg.softuni.examprep.models.entities;

import bg.softuni.examprep.models.enums.CategoryType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "categories")
@Entity
@RequiredArgsConstructor
public class Category extends BaseEntity {

    @NonNull
    @Enumerated(value = EnumType.STRING)
    private CategoryType type;

    @NonNull
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Item> items;

}
