package bg.softuni.carshop.models.entity;

import bg.softuni.carshop.models.entity.base.CreatedModifiedHistoryBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand extends CreatedModifiedHistoryBaseEntity {

    @Column
    private String name;




}
