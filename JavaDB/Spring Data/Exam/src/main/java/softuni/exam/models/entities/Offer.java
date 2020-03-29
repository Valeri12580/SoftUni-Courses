package softuni.exam.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="offers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offer  extends BaseEntity{

    @Column
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal price;

    @Column
    @Size(min = 5)
    private String description;

    @Column
    private boolean hasGoldStatus;

    @Column(name="added_on")
    private LocalDateTime addedOn;

    @NotNull
    @ManyToOne
    @JoinColumn(name="car_id",referencedColumnName = "id")
    private Car car;

    @NotNull
    @ManyToOne
    @JoinColumn(name="seller_id",referencedColumnName = "id")
    private Seller seller;

    @ManyToMany
    @JoinTable(
            name = "offers_pictures",
            joinColumns = @JoinColumn(name = "offer_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id",referencedColumnName = "id"))
    List<Picture> pictures;
}
