package com.softuni.xmlprocessing.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {


    private String name;

    private int age;

    private String company;

    private List<Address> address;
}
