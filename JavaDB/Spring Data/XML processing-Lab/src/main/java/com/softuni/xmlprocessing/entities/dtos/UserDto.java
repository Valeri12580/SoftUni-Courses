package com.softuni.xmlprocessing.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDto {

    @XmlElement
    private String name;

    @XmlElement
    private String age;

    @XmlElement
    private List<AddressDto> address;

}
