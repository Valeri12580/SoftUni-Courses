package thirdExercise;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public void setFirstName(String name) {
        if(name.length()<3 ){
            throw  new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length()<3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva", getFirstName(), getLastName(), getSalary());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary<460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        double salaryWithBonus=0;
        if(getAge()<30){
            salaryWithBonus=salary+(salary*(bonus/2)/100);

        }else{
            salaryWithBonus=salary+(salary*(bonus)/100);
        }
        setSalary(salaryWithBonus);

    }
}

