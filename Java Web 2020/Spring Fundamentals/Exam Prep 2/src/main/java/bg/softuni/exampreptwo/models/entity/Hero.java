package bg.softuni.exampreptwo.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
@NoArgsConstructor
@Getter
@Setter
public class Hero extends BaseEntity {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private HeroClass heroClass;

    @Column
    private int level;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
