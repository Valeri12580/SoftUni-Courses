package softuni.exam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name="pictures")
public class Picture extends  BaseEntity {

    @Column(unique = true)
    @NotNull
    private String url;

    @OneToMany(mappedBy = "picture")
    private Set<Team> team;

    @OneToMany(mappedBy = "picture")
    private Set<Player>players;

    public Picture() {

    }

    public Picture(@NotNull String url) {
        this.url = url;

    }

    public Picture(int id, @NotNull String url) {
        super(id);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
