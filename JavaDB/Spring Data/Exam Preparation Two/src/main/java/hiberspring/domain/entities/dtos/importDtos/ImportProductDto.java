package hiberspring.domain.entities.dtos.importDtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportProductDto {

    @XmlAttribute(name="name")
    private String name;

    @XmlAttribute(name="clients")
    private int clients;

    @XmlElement(name="branch")
    private String branch;
}
