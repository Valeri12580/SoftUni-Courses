package models.view;

import java.math.BigDecimal;

public class EmployeeViewModel {

    private String firstName;

    private int id;

    private String lastName;


    private String position;


    private BigDecimal salary;


    private int age;

    public EmployeeViewModel() {
    }

    public EmployeeViewModel(String firstName, int id, String lastName, String position, BigDecimal salary, int age) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.age = age;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
