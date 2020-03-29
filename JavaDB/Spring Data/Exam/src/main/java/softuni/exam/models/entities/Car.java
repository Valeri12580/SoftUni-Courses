package softuni.exam.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cars")
public class Car  extends BaseEntity{

    @Column
    @Size(min = 2,max=19)
    private String make;

    @Column
    @Size(min = 2,max=19)
    private String model;

    @Column
    @Min(value = 0)
    private long kilometers;

    @Column(name="registered_on")
    private LocalDate registeredOn;

    @OneToMany(mappedBy = "car",fetch = FetchType.EAGER)
    private Set<Picture> pictures;


    @OneToMany(mappedBy = "car")
    private Set<Offer>offers;


}
