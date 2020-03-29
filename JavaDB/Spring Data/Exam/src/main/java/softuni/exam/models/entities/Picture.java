package softuni.exam.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="pictures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Picture  extends BaseEntity{

    @Column(unique = true)
    @Size(min = 2,max=19)
    private String name;

    @Column(name="date_and_time")
    private LocalDateTime dateAndTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name="car_id",referencedColumnName = "id")
    private Car car;



    @ManyToMany(mappedBy = "pictures")
    private List<Offer> offers;
}
