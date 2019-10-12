public class Child extends Student {
    public Child(String firstName, String lastName) {
        super(firstName, lastName);
    }


    public String getNameFirst() {
        return super.firstName;
    }
}
