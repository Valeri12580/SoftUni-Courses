package com.softuni.judgeversiontwo.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="comments")
public class Comment extends BaseEntity {

    @Column
    private int score;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "homework_id",referencedColumnName = "id")
    private Homework homework;


}
