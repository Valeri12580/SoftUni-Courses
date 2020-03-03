package entities.university.abstraction;

import entities.university.Course;
import entities.university.abstraction.interfaces.Person;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasePerson  implements Person {
    private int id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    protected Set<Course> courses;




    public BasePerson() {
    }

    public BasePerson(int id, String firstName, String lastName, int phoneNumber,Set<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        setCourses(courses);

    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    @Column(name="first_name")
    public String getFirstName() {
        return this.firstName;
    }

    @Override

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    @Override
    @Column(name="last_name")
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    @Override
    @Column(name="phone_number")
    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber=phoneNumber;
    }

    @Override
    public void setCourses(Set<Course>courses) {
            this.courses=courses;
    }
}
