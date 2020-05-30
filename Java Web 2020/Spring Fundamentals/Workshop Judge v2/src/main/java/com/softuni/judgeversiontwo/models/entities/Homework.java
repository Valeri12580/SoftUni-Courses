package com.softuni.judgeversiontwo.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="homeworks")
public class Homework  extends BaseEntity{

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @CreationTimestamp
    private LocalDateTime addedOn;

    @Column(nullable = false,unique = true)
//    @Pattern(message = "Invalid github link",regexp = "^https:\\/\\/github\\.com\\/([^\\/]+(\\/{1,1}|[^\\/]+))(?1)*$")
    private String git;


    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "exercise_id",referencedColumnName = "id")
    private  Exercise exercise;

}
