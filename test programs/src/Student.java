public class Student implements Comparable<Student> {
    protected String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public int compareTo(Student o) {
        int result = this.lastName.compareTo(o.lastName);
        if (result == 0) {
            result = this.firstName.compareTo(o.firstName);
        }
        return result;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
