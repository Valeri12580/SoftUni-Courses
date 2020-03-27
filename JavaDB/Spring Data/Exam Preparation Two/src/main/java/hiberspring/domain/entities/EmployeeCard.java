package hiberspring.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employee_cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCard  extends BaseEntity{

    @NotNull
    @Column(unique = true)
    private String number;
}
