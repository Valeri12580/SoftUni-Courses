package hiberspring.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    @Min(value = 1)
    private int clients;

    @NotNull
    @ManyToOne
    @JoinColumn(name="branch_id",referencedColumnName = "id")
    private Branch branch;
}
