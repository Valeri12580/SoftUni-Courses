package com.softuni.jsonprocessing.model;


import com.google.gson.annotations.Expose;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Post {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Expose
    @NonNull
    @Length(min=3,max=80)
    private String title;

    @Expose
    @NonNull
    @Length(min=3,max=2048)
    private String content;


    @Expose
    @ManyToOne(optional = true)
    @JoinColumn(name="author_id",referencedColumnName = "id")
    private User author;

    @Expose
    private Date created=new Date();

    @Expose
    private Date modified=new Date();

    @Expose(serialize = false)
    @Transient
    private Long authorId;




}
