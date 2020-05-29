package bg.example.exampreparation.models.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @ManyToMany
    @JoinTable(name = "users_friends",joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id"),
    },inverseJoinColumns = @JoinColumn(name = "friend_id",referencedColumnName = "id"))
    private Set<User> friends;


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
