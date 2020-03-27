package hiberspring.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="branch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Branch extends BaseEntity {

    @NotNull
    @Column
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name="town_id",referencedColumnName = "id")
    private Town town;

    @OneToMany(mappedBy = "branch")
    private Set<Product> products;
}

