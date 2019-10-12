package competitorEntries.entities;

import javax.persistence.*;

@Entity
@Table(name = "competitors")
public class Competitor {
    private int id;
    private String name;
    private int age;
    private String team;
    private String category;


    public Competitor(){

    }

    public Competitor(String name, int age, String team, String category) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.category = category;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="age",nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Column(name="team",nullable = false)
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    @Column(name="category",nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
