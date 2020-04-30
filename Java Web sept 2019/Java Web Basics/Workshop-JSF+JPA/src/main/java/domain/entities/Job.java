package domain.entities;

import enums.Sectors;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class Job extends BaseEntity {


    @Enumerated(EnumType.STRING)
    @Column
    private Sectors sector;

    @Column
    private String profession;

    @Column
    private BigDecimal salary;

    @Column
    private String description;


    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public Job() {
    }

    public Sectors getSector() {
        return sector;
    }

    public void setSector(Sectors sector) {
        this.sector = sector;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
