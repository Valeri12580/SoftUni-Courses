package com.softuni.xmlprocessing.entities;


import com.softuni.xmlprocessing.entities.dtos.UserDto;
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
@XmlRootElement(name="Users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name="user")
    private List<UserDto> userDtoList;
}
