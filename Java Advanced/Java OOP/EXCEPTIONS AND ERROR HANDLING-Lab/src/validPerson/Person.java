package validPerson;

public class Person {
    private String  firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.isBlank()){
            throw new IllegalArgumentException("The first name cannot be null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.isEmpty() || lastName.equals("null")) {
            throw new IllegalArgumentException("The last name cannot be null");

        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0 || age>120) {
            throw new IllegalArgumentException("Age shoud be in age[0...120]");

        }
        this.age = age;
    }
}
