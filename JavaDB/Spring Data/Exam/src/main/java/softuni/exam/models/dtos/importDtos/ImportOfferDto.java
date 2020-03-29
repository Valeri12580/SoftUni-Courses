package softuni.exam.models.dtos.importDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.config.LocalDateTimeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportOfferDto {

    @XmlElement
    private String description;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name="added-on")
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    private LocalDateTime addedOn;

    @XmlElement(name="has-gold-status")
    private boolean hasGoldStatus;

    @XmlElement(name="car")
    private InnerCarDto car;

    @XmlElement(name="seller")
    private InnerSellerDto seller;
}
