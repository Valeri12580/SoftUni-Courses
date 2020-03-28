package alararestaurant.domain.entities;

import alararestaurant.domain.OrderType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order  extends BaseEntity{

    @Column
    private String customer;

    @Column
    private LocalDateTime dateTime;


    @Enumerated
    private OrderType type;

    @ManyToOne
    @JoinColumn(name="employee_id",referencedColumnName = "id")
    private Employee employee;


    @OneToMany(mappedBy = "order")
    Set<OrderItem>orderItems;

}
