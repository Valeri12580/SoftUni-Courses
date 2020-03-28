package alararestaurant.domain.dtos.importDtos;

import alararestaurant.config.LocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {


    @XmlElement
    private String customer;

    @XmlElement
    private String employee;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name="date-time")
    private LocalDateTime dateTime;

    @ColumnDefault("ForHere")
    private String type;

    @XmlElement(name="items")
    ImportItemRootDto items;
}
