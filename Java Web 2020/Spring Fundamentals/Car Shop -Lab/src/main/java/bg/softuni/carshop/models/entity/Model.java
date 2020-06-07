package bg.softuni.carshop.models.entity;

import bg.softuni.carshop.models.entity.base.CreatedModifiedHistoryBaseEntity;
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
public class Model extends CreatedModifiedHistoryBaseEntity {

    public Model(String name, String imageUrl, int startYear, int endYear) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column
    private int startYear;

    @Column
    private int endYear;

    @ManyToOne
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private Brand brand;
}
