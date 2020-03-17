package com.softuni.automappingobjects.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game extends BaseEntity {

    @Column
    private String title;

    @Column
    private double price;


    @Column
    private double size;


    private String trailer;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column
    private String description;

    @Column
   private  LocalDate date;

    @ManyToMany(mappedBy = "games",targetEntity = User.class)
    private Set<User> user;


    @ManyToMany(mappedBy = "games")
    private Set<Order>orders;


}
