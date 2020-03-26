package softuni.exam.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="teams")
public class Team extends BaseEntity {

    @NotNull
    @Column
    @Size(min=3,max = 15)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name="picture_id",referencedColumnName = "id")
    private Picture picture;

    @OneToMany(mappedBy = "team")
    private Set<Player> players;

    public Team() {
    }

    public Team(@NotNull @Size(min = 3, max = 15) String name, Picture picture) {
        this.name = name;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
