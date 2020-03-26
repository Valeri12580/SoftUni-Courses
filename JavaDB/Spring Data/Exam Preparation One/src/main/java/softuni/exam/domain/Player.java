package softuni.exam.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name="players")
public class Player  extends BaseEntity{

    @NotNull
    private String firstName;

    @NotNull
    @Size(min=3,max=15)
    private String lastName;

    @Min(value = 1)
    @Max(value = 99)
    private int number;

    @NotNull
    @Min(value = 0)
    private BigDecimal salary;

    @NotNull
    @Enumerated
    private Positions position;

    @NotNull
    @ManyToOne
    @JoinColumn(name="picture_id",referencedColumnName = "id")
    private Picture picture;

    @NotNull
    @ManyToOne
    @JoinColumn(name="team_id",referencedColumnName = "id")
    private Team team;

    public Player(String firstName, String lastName, int number, BigDecimal salary, Positions positions, Picture picture, Team team) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.salary = salary;
        this.position = positions;
        this.picture = picture;
        this.team = team;
    }

    public Player() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
