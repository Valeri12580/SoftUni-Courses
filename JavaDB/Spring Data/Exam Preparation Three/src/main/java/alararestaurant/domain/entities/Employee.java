package alararestaurant.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {

    @Column
    private int age;

    @Column
    private String name;

    @ManyToOne(cascade =CascadeType.PERSIST)
    @JoinColumn(name="position_id",referencedColumnName = "id")
    private Position position;

    @OneToMany(mappedBy = "employee")
    Set<Order> orders;


}
