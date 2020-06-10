package bg.softuni.carshop.models.entity;

import bg.softuni.carshop.models.entity.base.BaseEntity;
import bg.softuni.carshop.models.enums.Role;
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
public class UserRole extends BaseEntity {

    @Column
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
