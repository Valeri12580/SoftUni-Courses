package com.softuni.jsonprocessing.model;

import com.google.gson.annotations.Expose;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    @NonNull
    @Length(min=3,max=80)
    private String firstName;

    @Expose
    @NonNull
    @Length(min=3,max=80)
    private String lastName;

    @Expose
    @NonNull
    @Length(min=3,max=80)
    @Column(unique = true,nullable = false)
    @NotNull
    private String username;

    @Expose(serialize = false)
    @NonNull
    @Length(min=3,max=80)
    @Column(nullable = false)
    @NotNull
    private String password;

    @Expose
    @NotNull
    @NonNull
    private String role="ROLE_USER";

    @Expose
    private boolean  isActive=true;


    @OneToMany(mappedBy = "author")
    private Set<Post> authors;

    @Expose
    private Date created=new Date();
    @Expose
    private Date modified=new Date();






}
