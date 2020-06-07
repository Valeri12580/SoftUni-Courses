package bg.softuni.carshop.models.entity;

import bg.softuni.carshop.models.entity.base.CreatedModifiedHistoryBaseEntity;
import bg.softuni.carshop.models.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User  extends CreatedModifiedHistoryBaseEntity {
    @Column
    private String username;

    @Column
    private String firstName;


    @Column
    private String lastName;

    @Column
    private boolean active;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private UserRole role;


}
