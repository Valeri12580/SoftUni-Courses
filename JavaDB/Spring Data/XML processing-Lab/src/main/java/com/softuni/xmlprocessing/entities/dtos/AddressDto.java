package com.softuni.xmlprocessing.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@XmlRootElement(name="address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDto {

    @XmlElement
    private String city;
}
