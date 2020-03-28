package alararestaurant.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categories")

public class Category  extends  BaseEntity{

    public Category(String name) {
        this.name = name;
    }

    @Column
    private String name;


    @Column
    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
    private Set<Item> items;


}
