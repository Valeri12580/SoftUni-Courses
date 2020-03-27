package hiberspring.domain.entities.dtos.importDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportEmployeeDto {

    @XmlAttribute(name="first-name")
    private String firstName;

    @XmlAttribute(name="last-name")
    private String lastName;

    @XmlAttribute(name="position")
    private String position;

    @XmlElement(name="card")
    private String card;

    @XmlElement(name="branch")
    private String branch;
}
