package entities.university;

import entities.university.abstraction.BasePerson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="teachers")
public class Teacher extends BasePerson {
    private String email;
    private BigDecimal salaryPerHour;

    public Teacher() {
    }



    public Teacher(int id, String firstName, String lastName, int phoneNumber, Set<Course> courses, String email, BigDecimal salaryPerHour) {
        super(id, firstName, lastName, phoneNumber, courses);
        this.email = email;
        this.salaryPerHour = salaryPerHour;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name="salary_per_hour")
    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }


    @OneToMany(mappedBy = "teacher",targetEntity = Course.class)
    @Override
    public Set<Course> getCourses() {
        return super.courses;
    }


}
