package bg.softuni.carshop.models.entity;

import bg.softuni.carshop.models.entity.base.CreatedModifiedHistoryBaseEntity;
import bg.softuni.carshop.models.enums.Categories;
import bg.softuni.carshop.models.enums.Engine;
import bg.softuni.carshop.models.enums.Roles;
import bg.softuni.carshop.models.enums.Transmission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Offer extends CreatedModifiedHistoryBaseEntity {
    @Column
    @Enumerated(value = EnumType.STRING)
    private Categories category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Engine engine;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column
    private long mileage;

    @Column
    private double price;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;

    @Column
    private int year;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="model_id",referencedColumnName = "id")
    private Model model;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User seller;


}
