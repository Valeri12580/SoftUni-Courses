package alararestaurant.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="positions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position extends BaseEntity {

    @Column
    private String name;



    public Position(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "position")
    private Set<Employee> employee;

}
