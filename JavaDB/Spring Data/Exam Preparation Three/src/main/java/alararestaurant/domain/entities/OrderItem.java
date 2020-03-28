package alararestaurant.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem  extends BaseEntity{

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name="item_id",referencedColumnName = "id")
    private Item item;

    @ManyToOne
    @JoinColumn(name="order_id",referencedColumnName = "id")
    private Order order;
}
