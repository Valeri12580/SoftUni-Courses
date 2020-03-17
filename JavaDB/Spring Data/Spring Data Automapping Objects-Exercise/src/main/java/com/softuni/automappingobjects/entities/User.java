package com.softuni.automappingobjects.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;


@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {


    @Column(name = "email",unique = true)
    private String email;

    @Column
    private String password;

    @Column(name = "full_name")
    private String fullName;



    @Column
    @Enumerated(value = EnumType.STRING)
    private Role Role;

    @ManyToMany
    @JoinTable(name="users_games",
    joinColumns=@JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name = "game_id",referencedColumnName = "id") )
    private Set<Game> games;

    @OneToMany(mappedBy = "user",targetEntity = Order.class)
    private Set<Order>orders;





}
