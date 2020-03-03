package entities.university.abstraction.interfaces;

import entities.university.Course;

import java.util.Set;

public interface Person {
    int getId();

    void setId(int id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    int getPhoneNumber();

    void setPhoneNumber(int phoneNumber);

    Set<Course> getCourses();

    void setCourses(Set<Course>courses);
}
