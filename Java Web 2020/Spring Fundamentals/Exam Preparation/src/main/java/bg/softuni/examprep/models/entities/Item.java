package bg.softuni.examprep.models.entities;


import bg.softuni.examprep.models.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "items")
public class Item extends BaseEntity{
    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
}
