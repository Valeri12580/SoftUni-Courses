package com.softuni.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    private int age;

    @Column(name="first_name")
    private String fistName;

    @Column(name="last_name")
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="users_friends",
    joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="friend_id",referencedColumnName = "id"))
    private Set<User> friends;

    @OneToMany(mappedBy = "buyer")
    public  Set<Product>bought;

    @OneToMany(mappedBy = "seller")
    public  Set<Product> sold;


}
