package hiberspring.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {

    @NotNull
    @Column
    private String firstName;

    @NotNull
    @Column
    private String lastName;

    @NotNull
    @Column
    private String position;

    @NotNull
    @OneToOne
    @JoinColumn(name="card_id",referencedColumnName = "id")
    private EmployeeCard card;

    @NotNull
    @ManyToOne
    @JoinColumn(name="branch_id",referencedColumnName = "id")
    private Branch branch;


}
