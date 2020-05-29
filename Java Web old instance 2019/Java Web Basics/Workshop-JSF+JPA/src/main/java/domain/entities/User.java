package domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table
public class User extends BaseEntity {

    @Column(unique = true)
    @NotNull(message = "The username must not be empty")
    private String username;

    @Column
    @NotNull(message = "The password must not be empty")
    private String password;

    @Column(unique = true)
    @NotNull(message = "The email must not be empty")
    @Email(message = "The email is not valid!")
    private String email;


    @OneToMany(mappedBy = "user")
    private Set<Job> jobs;

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
}
