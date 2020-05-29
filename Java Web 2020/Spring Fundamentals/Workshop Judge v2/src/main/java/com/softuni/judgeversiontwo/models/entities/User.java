package com.softuni.judgeversiontwo.models.entities;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User extends BaseEntity {

    @Column(nullable = false,unique = true)
    @Length(min = 2,message = "Username length must be minimum two characters!")
    private String username;

    @Column(nullable = false)
    @Length(min = 2,message = "Username length must be minimum two characters!")
    private String password;

    @Email
    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
//    @Pattern()
    private String git;


    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;


}
